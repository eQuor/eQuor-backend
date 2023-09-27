package com.eQuor.backend.services;


import com.eQuor.backend.dto.MobileInfoDto;
import com.eQuor.backend.dto.StudentInfoDto;
import com.eQuor.backend.dto.TestDTO;
import com.eQuor.backend.models.Mobile;
import com.eQuor.backend.models.Student;
import com.eQuor.backend.models.Test;
import com.eQuor.backend.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private static StudentRepository studentRepository;

    @Autowired
    private static ModelMapper modelMapper;

    public String registerDevice(MobileInfoDto mobileInfoDto) {
        Mobile mobile = this.modelMapper.map(mobileInfoDto, Mobile.class);
        System.out.println(mobile);
        return "";
    }


//    public static Student getUserByName(String name){
//         Student student= studentRepository.getUserByName(name);
//        return student;
//    }

    public static StudentInfoDto updateStudent(Authentication authentication) {
        // Create an instance of ModelMapper
        ModelMapper modelMapper = new ModelMapper();

        String name = authentication.getName();
        Optional<Student> studentOptional = Optional.ofNullable(StudentRepository.findByUsername(name));

        // Check if the studentOptional is present to avoid NullPointerException
        if (studentOptional.isPresent()) {
            String qr = "1234";
            Student student = studentOptional.get();
            student.setDeviceQr(qr);
            studentRepository.save(student);

            // Convert the updated Student entity to StudentInfoDto and return it
            StudentInfoDto studentInfoDto = modelMapper.map(student, StudentInfoDto.class);
            return studentInfoDto;
        } else {
            // Handle the case where the student with the given username doesn't exist
            throw new UsernameNotFoundException("User not found with username: " + name);
        }
    }

//    public void updateStudentAgeById(Long studentId, int newAge) {
//        Optional<Student> studentOptional = studentRepository.findById(studentId);
//        if (studentOptional.isPresent()) {
//            Student student = studentOptional.get();
//            student.setAge(newAge);
//            studentRepository.save(student);
//        } else {
//            // Handle the case where the student with the given ID doesn't exist
//        }
//    }

}