package com.eQuor.backend.services;

import com.eQuor.backend.dto.LecturerAttendaneStat;
import com.eQuor.backend.dto.OnlineStudentInfoDTO;
import com.eQuor.backend.models.OnlineStudentInfo;
import com.eQuor.backend.repositories.OnlineStudentInfoRepository;
import com.eQuor.backend.repositories.StudentAttendSessionRepository;
import com.eQuor.backend.repositories.StudentModuleRepository;
import org.hibernate.mapping.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class LecturerService {

    @Autowired
    private StudentAttendSessionRepository studentAttendSessionRepository;
    @Autowired
    private StudentModuleRepository studentModuleRepository;
    @Autowired
    private ModelMapper modelMapper;

    public LecturerAttendaneStat getattendancecont() {
        Long count = studentAttendSessionRepository.count();
        Long allStudent = studentModuleRepository.count();

        LecturerAttendaneStat lecturerAttendaneStat = new LecturerAttendaneStat();
        lecturerAttendaneStat.setAttendStudent(count);
        lecturerAttendaneStat.setAllStudent(allStudent);

        return lecturerAttendaneStat;
    }
    @Autowired
    private OnlineStudentInfoRepository studentInfoRepository;

    public List<OnlineStudentInfoDTO> getAllOnlineStudentBySessionId(Integer session_id ) {
        List<OnlineStudentInfo> studentInfoList = studentInfoRepository.getAllOnlineStudentBySessionId(session_id);
        return studentInfoList.stream().map(studentInfo -> modelMapper.map(studentInfo, OnlineStudentInfoDTO.class))
                .collect(Collectors.toList());
    }
}