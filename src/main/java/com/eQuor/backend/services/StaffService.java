package com.eQuor.backend.services;



import com.eQuor.backend.dto.LecturerModuleDto;
import com.eQuor.backend.dto.MobileInfoDto;
import com.eQuor.backend.dto.StudentInfoDto;
import com.eQuor.backend.dto.TestDTO;
import com.eQuor.backend.models.*;
import com.eQuor.backend.repositories.LecturerRegisterModuleRepository;
import com.eQuor.backend.repositories.StudentRegisterModuleRepository;
import com.eQuor.backend.repositories.StudentRepository;
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
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@Transactional
public class StaffService {
    @Autowired
    private LecturerRegisterModuleRepository lecturerrepository;

    @Autowired
    private StudentRegisterModuleRepository studentrepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<LecturerRegisterModule>saveAllLecturers(List<LecturerRegisterModule> lecturerModules){

        return lecturerrepository.saveAll(lecturerModules);
    }

    public List<StudentRegisterModule> saveAllStudents(List<StudentRegisterModule> studentModules){

        return studentrepository.saveAll(studentModules);
    }



}

