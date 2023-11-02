package com.eQuor.backend.services;


import com.eQuor.backend.dto.*;
import com.eQuor.backend.models.*;
import com.eQuor.backend.models.Module;
import com.eQuor.backend.repositories.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentHasSessionRepository studentHasSessionRepository;

    @Autowired
    private StudentAttendSessionRepository studentAttendSessionRepository;

    @Autowired
    private MobileRepository mobileRepository;

    @Autowired
    private SessionRepository sessionRepository;



    @Autowired
    private  ModuleRepository moduleRepository;


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String registerDevice(MobileInfoDto mobileInfoDto){
        Mobile mobile = this.modelMapper.map(mobileInfoDto, Mobile.class);
        System.out.println(mobile);
        return "";
    }
    
public StudentInfoDto updateQr(Authentication authentication) {
    String username = authentication.getName();
    String token = authentication.getCredentials().toString();

    // Generating random number
    Random random = new Random();
    int randomNumber = random.nextInt(100);

    String result = username + randomNumber;

    StringBuilder hexString = null;
    try {
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        // Compute the hash of the input string
        byte[] hash = md.digest(result.getBytes(StandardCharsets.UTF_8));

        // Convert the hash to a hexadecimal string
        hexString = new StringBuilder();
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }

        // Print the hash
        System.out.println(hexString);

        Student student = studentRepository.findByUsername(username);

        if (student != null) {
            // Update the QR code for the student
            student.setQrCode(hexString.toString()); // Convert the StringBuilder to a String
            student.setToken(token);
            studentRepository.save(student);
        }
    } catch (NoSuchAlgorithmException e) {
        e.printStackTrace();
    }

    StudentInfoDto studentInfoDto = new StudentInfoDto();
    studentInfoDto.setUserName(authentication.getName());
    studentInfoDto.setQrString(hexString.toString());




    //return hexString.toString();

    return studentInfoDto;
}
    public List<Module> getStudentMd(String userId){

        return moduleRepository.getStudentModuleByStudentId(userId);


    }

    public StudentAttendanceStatDto getStudentAttendanceStat(String userId,Integer moduleId){

        return new StudentAttendanceStatDto(sessionRepository.countByModuleId(moduleId),
                sessionRepository.countByMAttendance(userId, moduleId));
    }

    public DeviceRegisterResponseDto registerStudentDevice(MobileInfoDto mobileDto, String username){
        DeviceRegisterResponseDto deviceRegisterResponseDto = new DeviceRegisterResponseDto();
        try {

            //hashing
            String mobileData = mobileDto.toString();
            mobileData = mobileData + username;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(mobileData.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            System.out.println(hexString.getClass());
            String hex = hexString.toString();


            Student student = this.studentRepository.findByUsername(username);




            //check is registered
            if(student==null){
                deviceRegisterResponseDto.setIsRegistered(false);
                deviceRegisterResponseDto.setError("Authentication error");
            }
            else {
                //check is it the correct QR
                String savedQr = student.getQrCode();
                if (!savedQr.equals(mobileDto.getScannedQR())){
                    deviceRegisterResponseDto.setIsRegistered(false);
                    deviceRegisterResponseDto.setError("Please scan your correct eQuor QR Code");
                    return deviceRegisterResponseDto;
                }


                if (student.getMobile_id() == null){
                    student.setMobile_id(hex);
                    Mobile mobile = new Mobile(hex, mobileDto.getDeviceName(),mobileDto.getOsVersion());
                    mobileRepository.save(mobile);
                    studentRepository.save(student);
                    deviceRegisterResponseDto.setIsRegistered(true);
                    deviceRegisterResponseDto.setError("Device registration complete!");
                }
                else if(student.getMobile_id().equals(hex)){
                    deviceRegisterResponseDto.setIsRegistered(true);
                    deviceRegisterResponseDto.setError("Already exists!");
                }
                else{
                    deviceRegisterResponseDto.setIsRegistered(false);
                    deviceRegisterResponseDto.setError("You cannot register multiple devices!");
                }

            }
            return deviceRegisterResponseDto;


        } catch (Exception e) {
            e.printStackTrace();
            deviceRegisterResponseDto.setIsRegistered(false);
            deviceRegisterResponseDto.setError("Unexpected error occurred! Please try again..");
            return deviceRegisterResponseDto;

        }



    }




    public GetSessionDTO getSession(String userId, Integer sessionId){
        System.out.println("Catched");
        GetSessionDTO getSessionDTO = new GetSessionDTO();
        System.out.println("Catched");
//    getSessionDTO.setIsFound(true);
//    getSessionDTO.setSessionDetails(studentSessionDetails);
        StudentHasSessionPKey studentHasSessionPKey = new StudentHasSessionPKey(userId, sessionId);
        StudentHasSession studentHasSession = studentHasSessionRepository.findUserById(userId, sessionId);
        getSessionDTO.setIsFound(studentHasSession != null);
        return getSessionDTO;

    }






    public MarkAttendanceResponseDto mark_attendance(MarkAttendanceRequestDto markAttendanceRequestDto, String userId){
        System.out.println(markAttendanceRequestDto.getCodes());
        System.out.println(markAttendanceRequestDto.getSessionId());
        System.out.println(userId);
        MarkAttendanceResponseDto markAttendanceResponseDto = new MarkAttendanceResponseDto(false, "Unknown Error occurred");

        StudentHasSessionPKey studentHasSessionPKey = new StudentHasSessionPKey(userId, markAttendanceRequestDto.getSessionId());
        StudentHasSession studentHasSession = studentHasSessionRepository.findByPkey(studentHasSessionPKey);
        if (studentHasSession == null){
            System.out.println("You don't have access for this session");
        }
        else{
            System.out.println("session found");
            Sessions session = sessionRepository.findSessionsById(markAttendanceRequestDto.getSessionId());
            if (session == null){
                System.out.println("Unexpected error happened!");
            }
            else{
                System.out.println(session);
                System.out.println(session.getQr_code());
                String[] strArray = session.getQr_code().substring(1, session.getQr_code().length()-1).split(", ");
                List<Integer> integerList = new ArrayList<>();
                for (String s : strArray) {
                    integerList.add(Integer.parseInt(s));
                }
                int matchCount = 0;
                for (int i = 0; i < markAttendanceRequestDto.getCodes().size(); i++) {
                    System.out.println("Meka wed");
                    if (this.findValueInArray(markAttendanceRequestDto.getCodes().get(i), integerList)){
                        integerList.remove(markAttendanceRequestDto.getCodes().get(i));
                        matchCount++;
                    }
                }
                System.out.println(matchCount);
                if (matchCount>6){
                    markAttendanceResponseDto.setIsMarked(true);
                    markAttendanceResponseDto.setError("Attendance marked!");
                    Student_attend_session studentAttendSession = new Student_attend_session();
                    St_attend stAttend = new St_attend(userId, markAttendanceRequestDto.getSessionId());
                    studentAttendSession.setId(stAttend);
                    studentAttendSessionRepository.save(studentAttendSession);
                }
                else{
                    markAttendanceResponseDto.setIsMarked(false);
                    markAttendanceResponseDto.setError("You have scanned only " + matchCount +  " matching QR Codes");
                }
            }
        }
        return markAttendanceResponseDto;
    }







    private Boolean findValueInArray(Integer value, List<Integer> list){
        for (Integer integer : list) {
            if (integer.equals(value)){
                return true;
            }


        }
        return false;
    }







}
