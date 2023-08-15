package com.eQuor.backend.controllers;

import com.eQuor.backend.models.Student;
import com.eQuor.backend.services.StaffService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/staff")
public class StaffController {

    public StaffController(StaffService staffService) {this.staffService = staffService;}
    private StaffService staffService;
    @PostMapping("/createStudent")
    public String creteStudent(@RequestBody Student student) throws ExecutionException, InterruptedException {
       return staffService.createStudent(student);
    }
}
