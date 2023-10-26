package com.eQuor.backend.controllers;


import com.eQuor.backend.dto.StudentInfoDto;
import com.eQuor.backend.models.Module;
import com.eQuor.backend.repositories.ModuleRepository;
import com.eQuor.backend.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/staff")
public class StaffController {

    @Autowired
    private ModuleRepository moduleRepository;

//    @GetMapping("/getModule/{id}")
//    @CrossOrigin
//    public void getModule(int id){
//
//
//
//    }

    @GetMapping("/getUserById/{id}")
    public Module getUserById(@PathVariable int id){

        Module module = moduleRepository.findById(id);
        return module;

    }
}
