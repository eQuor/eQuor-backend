package com.eQuor.backend.services;



import com.eQuor.backend.dto.*;
import com.eQuor.backend.models.*;
import com.eQuor.backend.repositories.LecturerRegisterModuleRepository;
import com.eQuor.backend.repositories.LecturerRepository;
import com.eQuor.backend.repositories.StudentRegisterModuleRepository;
import com.eQuor.backend.repositories.StudentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
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


    //Getting all lectures for a module
    @Autowired
    private LecturerRepository lecturerRepository;

    @Autowired
    private LecturerRegisterModuleRepository lecturerRegisterModuleRepository;


//    public List<LecturerModuleDto> getLecturersByModuleId(int moduleId) {
//        return lecturerRepository.findLecturersByModuleId(moduleId);
//    }

    public List<LecturerModuleDto> getLecturersByModuleId(int moduleId) {
        List<Object[]> results = lecturerRepository.findLecturersByModuleId(moduleId);
        List<LecturerModuleDto> lecturers = new ArrayList<>();
        for (Object[] result : results) {
            String name = (String) result[0];
            String email = (String) result[1];
            lecturers.add(new LecturerModuleDto(name, email));
        }
        return lecturers;
    }

    @Autowired
    private StudentRepository stuRepository;

    public List<StudentModuleDto> getStudentsByModuleId(int moduleId) {
        List<Object[]> results = stuRepository.findStudentsByModuleId(moduleId);
        List<StudentModuleDto> students = new ArrayList<>();
        for (Object[] result : results) {
            String name = (String) result[0];
            String email = (String) result[1];
            students.add(new StudentModuleDto(name, email));
        }
        return students;
    }

}

