package com.eQuor.backend.controllers;


import com.eQuor.backend.dto.MobileInfoDto;
import com.eQuor.backend.dto.GetSessionDTO;
import com.eQuor.backend.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/student")
@CrossOrigin

public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/testMobile")
    public String registerDevice(@RequestBody MobileInfoDto mobileInfoDto) throws JSONException, InterruptedException {
        System.out.println("test mobile called");
        System.out.println(mobileInfoDto.toString());
        Thread.sleep(1000);
        System.out.println(mobileInfoDto.getDeviceName());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "hihi");
        return jsonObject.toString();
    }

    @GetMapping("/get-session")
    public GetSessionDTO getSession(){

    }
}
