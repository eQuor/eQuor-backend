package com.eQuor.backend.services;


import com.eQuor.backend.dto.AuthenticationResponse;
import com.eQuor.backend.dto.StudentInfoDto;
import com.eQuor.backend.models.Role;
import com.eQuor.backend.models.Student;
import com.eQuor.backend.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthService {

    @Autowired
    StudentRepository studentRepository;

    public AuthenticationResponse loginWithQR(StudentInfoDto studentInfoDto){
        Student student = studentRepository.findByUsername(studentInfoDto.getUserName());
        Role role = Role.NOAUTH;
        if (student == null ){
            return new AuthenticationResponse(studentInfoDto.getUserName(), "empty",false, List.of(new SimpleGrantedAuthority(role.name())));
        }
        else if ((student.getQrCode().equals("") || student.getToken().equals(""))){
            return new AuthenticationResponse(studentInfoDto.getUserName(), "empty",false, student.getAuthorities());
        }
        else
            return new AuthenticationResponse(studentInfoDto.getUserName(), student.getToken().toString(),true, student.getAuthorities());
    }
}
