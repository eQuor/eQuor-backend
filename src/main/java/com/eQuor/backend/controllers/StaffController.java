package com.eQuor.backend.controllers;


import com.eQuor.backend.dto.LecturerModuleDto;
import com.eQuor.backend.dto.StudentModuleDto;
import com.eQuor.backend.models.Lecturer;
import com.eQuor.backend.models.LecturerRegisterModule;
import com.eQuor.backend.models.Module;
import com.eQuor.backend.models.StudentRegisterModule;
import com.eQuor.backend.repositories.ModuleRepository;
import com.eQuor.backend.services.StaffService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Assign Lecturers to modules
    @Autowired
    private StaffService staffService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/lecturer-modules")
    public List<LecturerRegisterModule> saveAllLecturers(@RequestBody List<LecturerRegisterModule> lecturerModule){

        return staffService.saveAllLecturers(lecturerModule);
    }

    @PostMapping("/student-modules")
    public List<StudentRegisterModule> saveAllStudents(@RequestBody List<StudentRegisterModule> studentModule){

        return staffService.saveAllStudents(studentModule);
    }

    @GetMapping("/getLecbyModule/{moduleId}")
    public List<LecturerModuleDto> getLecturersByModule(@PathVariable int moduleId) {
        return staffService.getLecturersByModuleId(moduleId);
    }

    @GetMapping("/getStudentbyModule/{moduleId}")
    public List<StudentModuleDto> getStudentsByModule(@PathVariable int moduleId) {
        return staffService.getStudentsByModuleId(moduleId);
    }



}
