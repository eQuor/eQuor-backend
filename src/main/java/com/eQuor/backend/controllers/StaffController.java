//package com.eQuor.backend.controllers;
//
//import com.eQuor.backend.models.Lecturer;
//import com.eQuor.backend.models.Staff;
//import com.eQuor.backend.models.Student;
//import com.eQuor.backend.services.StaffService;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.concurrent.ExecutionException;
//
//@RestController
//@CrossOrigin
//@RequestMapping(value = "/api/v1/staff")
//public class StaffController {
//
//    public StaffController(StaffService staffService) {this.staffService = staffService;}
//    private StaffService staffService;
//    @PostMapping("/createStudent")
//    public String creteStudent(@RequestBody Student student) throws ExecutionException, InterruptedException {
//       return staffService.createStudent(student);
//    }@PostMapping("/createLecturer")
//    public String creteLecturer(@RequestBody Lecturer lecturer) throws ExecutionException, InterruptedException {
//       return staffService.createLecturer(lecturer);
//    }
//
//    @GetMapping("/getStudent")
//    public List<Student> getStudent(@RequestParam(required = false) String id) throws ExecutionException, InterruptedException {
//        return staffService.getStudent(id);
//    }@GetMapping("/getLecturer")
//    public List<Lecturer> getLecturer(@RequestParam(required = false) String id) throws ExecutionException, InterruptedException {
//        return staffService.getLecturer(id);
//    }
//}
