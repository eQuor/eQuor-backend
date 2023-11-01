package com.eQuor.backend.services;


import com.eQuor.backend.dto.MobileInfoDto;
import com.eQuor.backend.dto.StudentAttendanceStatDto;
import com.eQuor.backend.dto.StudentInfoDto;
import com.eQuor.backend.models.Mobile;
import com.eQuor.backend.models.Module;
import com.eQuor.backend.models.Student;
import com.eQuor.backend.repositories.ModuleRepository;
import com.eQuor.backend.repositories.SessionRepository;
import com.eQuor.backend.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.eQuor.backend.dto.DeviceRegisterResponseDto;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;

@Service
@Transactional
public class StudentService {

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
    studentInfoDto.setToken(token);



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
            if(student==null){
                deviceRegisterResponseDto.setIsRegistered(false);
                deviceRegisterResponseDto.setError("Authentication error");
            }
            else {
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





}
