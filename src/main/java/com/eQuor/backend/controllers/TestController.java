package com.eQuor.backend.controllers;

import com.eQuor.backend.dto.TestDTO;
import com.eQuor.backend.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/test")
@CrossOrigin

public class TestController {
    @Autowired
    private TestService testService;
    @PostMapping("/saveUser")
    public TestDTO saveUser(@RequestBody TestDTO testDTO){
       return testService.saveUser(testDTO);
    }
}
