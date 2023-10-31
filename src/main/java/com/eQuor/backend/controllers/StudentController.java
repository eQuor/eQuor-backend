package com.eQuor.backend.controllers;


import com.eQuor.backend.dto.*;
import com.eQuor.backend.services.StudentService;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/student")
@CrossOrigin

public class StudentController {

    @Autowired
    private final StudentService studentService;

    @Autowired
    private final JwtDecoder jwtDecoder;

    public StudentController(StudentService studentService, JwtDecoder jwtDecoder) {
        this.studentService = studentService;
        this.jwtDecoder = jwtDecoder;
    }

    @PostMapping("/testMobile")
    public DeviceRegisterResponseDto registerDevice(@RequestBody MobileInfoDto mobileInfoDto) throws JSONException, InterruptedException {
        System.out.println("test mobile called");
        System.out.println(mobileInfoDto.toString());
        Thread.sleep(1000);
        System.out.println(mobileInfoDto.getDeviceName());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Name is: "+authentication.getName());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "hihi");

        //String
        String mobileId = mobileInfoDto.toString();


        return studentService.registerStudentDevice(mobileInfoDto, authentication.getName());
    }

    @GetMapping("/get-session")
    public GetSessionDTO getSession(@RequestHeader("Authorization") String token, @RequestParam("session_id") Integer sessionId){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        String jwt = token.split(" ")[1];
        Jwt jwtToken = jwtDecoder.decode(jwt);
        String userId = jwtToken.getClaims().get("userId").toString();
        System.out.println(userId);
        return studentService.getSession(userId, sessionId);

//        return studentService.getSession();
    }

    @PostMapping("/mark-attendance")
    public MarkAttendanceResponseDto markAttendance(@RequestHeader("Authorization") String token,@RequestBody MarkAttendanceRequestDto markAttendanceRequestDto){
        System.out.println(markAttendanceRequestDto.getCodes());
        String jwt = token.split(" ")[1];
        Jwt jwtToken = jwtDecoder.decode(jwt);
        String userId = jwtToken.getClaims().get("userId").toString();
        return studentService.mark_attendance(markAttendanceRequestDto, userId);
    }


}



