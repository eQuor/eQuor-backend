package com.eQuor.backend.controllers;


import com.eQuor.backend.dto.MobileInfoDto;
import com.eQuor.backend.services.StudentService;
import com.eQuor.backend.models.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/student")
@CrossOrigin

public class StudentController {

    @Autowired
    private  final JwtDecoder jwtDecoder;

    @Autowired
    private  final  StudentService studentService;

    public StudentController(JwtDecoder jwtDecoder, StudentService studentService) {
        this.jwtDecoder = jwtDecoder;
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

    @GetMapping("/getStudentModule")
    public List<Module> getStudentModule(@RequestHeader("Authorization") String token){



        String jwt = token.split( " ")[1];
        Jwt jwtTokens = jwtDecoder.decode(jwt);
        String userID =jwtTokens.getClaims().get("userId").toString();

        System.out.println(userID);

        return studentService.getStudentMd(userID);


    }



}
