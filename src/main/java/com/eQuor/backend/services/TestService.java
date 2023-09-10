package com.eQuor.backend.services;

import com.eQuor.backend.dto.TestDTO;
import com.eQuor.backend.models.Test;
import com.eQuor.backend.repositories.TestRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {
    @Autowired
    private TestRepository testRepository;
    @Autowired
    private ModelMapper modelMapper;
    public TestDTO saveUser(TestDTO testDTO){
        testRepository.save(modelMapper.map(testDTO, Test.class));
        return testDTO;
    }
}
