package com.eQuor.backend.controllers;

import com.eQuor.backend.dto.LecturerAttendaneStat;
import com.eQuor.backend.models.Module;
import com.eQuor.backend.services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/lecture")
@CrossOrigin

public class LecturerController {

    @Autowired
    private LecturerService lecturerService;


    @GetMapping("/studentAttendSession/")

    public LecturerAttendaneStat getAttendance(){

        return lecturerService.getattendancecont();
    }

    @GetMapping("/getModules")
    public List<Module> getModule(){
        return lecturerService.getModules();
    }
}
