package com.eQuor.backend.services;


import com.eQuor.backend.dto.MobileInfoDto;
import com.eQuor.backend.dto.TestDTO;
import com.eQuor.backend.models.Mobile;
import com.eQuor.backend.models.Test;
import com.eQuor.backend.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String registerDevice(MobileInfoDto mobileInfoDto){
        Mobile mobile = this.modelMapper.map(mobileInfoDto, Mobile.class);
        System.out.println(mobile);
        return "";
    }
}
