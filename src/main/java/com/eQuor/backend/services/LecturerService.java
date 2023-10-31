package com.eQuor.backend.services;

import com.eQuor.backend.dto.LecturerAttendaneStat;
import com.eQuor.backend.models.Module;
import com.eQuor.backend.repositories.ModuleRepository;
import com.eQuor.backend.repositories.StudentAttendSessionRepository;
import com.eQuor.backend.repositories.StudentModuleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LecturerService {

    @Autowired
    private StudentAttendSessionRepository studentAttendSessionRepository;
    @Autowired
    private StudentModuleRepository studentModuleRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ModuleRepository moduleRepository;

    public LecturerAttendaneStat getattendancecont() {
        Long count = studentAttendSessionRepository.count();
        Long allStudent = studentModuleRepository.count();

        LecturerAttendaneStat lecturerAttendaneStat = new LecturerAttendaneStat();
        lecturerAttendaneStat.setAttendStudent(count);
        lecturerAttendaneStat.setAllStudent(allStudent);

        return lecturerAttendaneStat;
    }

    public List<Module> getModules(){
        return moduleRepository.getModuleByLecId("2020LEC123");
    }
}