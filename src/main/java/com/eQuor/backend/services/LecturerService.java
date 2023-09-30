package com.eQuor.backend.services;

import com.eQuor.backend.dto.OnlineStudentInfoDTO;
import com.eQuor.backend.models.OnlineStudentInfo;
import com.eQuor.backend.repositories.OnlineStudentInfoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class LecturerService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OnlineStudentInfoRepository studentInfoRepository;

    public List<OnlineStudentInfoDTO> getAllOnlineStudentBySessionId(Integer session_id ) {
        List<OnlineStudentInfo> studentInfoList = studentInfoRepository.getAllOnlineStudentBySessionId(session_id);
        return studentInfoList.stream().map(studentInfo -> modelMapper.map(studentInfo, OnlineStudentInfoDTO.class))
                .collect(Collectors.toList());
    }
}
