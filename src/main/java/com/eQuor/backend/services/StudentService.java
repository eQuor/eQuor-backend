package com.eQuor.backend.services;


import com.eQuor.backend.dto.MobileInfoDto;
import com.eQuor.backend.dto.StudentInfoDto;
import com.eQuor.backend.dto.TestDTO;
import com.eQuor.backend.models.Mobile;
import com.eQuor.backend.models.Module;
import com.eQuor.backend.models.Student;
import com.eQuor.backend.models.Test;
import com.eQuor.backend.repositories.ModuleRepository;
import com.eQuor.backend.repositories.StudentModuleRepository;
import com.eQuor.backend.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class StudentService {
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




}
