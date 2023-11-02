package com.eQuor.backend.controllers;


import com.eQuor.backend.dto.DeviceRegisterResponseDto;
import com.eQuor.backend.dto.GetSessionDTO;
import com.eQuor.backend.dto.MobileInfoDto;
import com.eQuor.backend.dto.MarkAttendanceRequestDto;
import com.eQuor.backend.dto.MarkAttendanceResponseDto;
import com.eQuor.backend.dto.StudentAttendanceStatDto;
import com.eQuor.backend.services.StudentService;
import com.eQuor.backend.models.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @GetMapping("/getStudentModule")
    public List<Module> getStudentModule(@RequestHeader("Authorization") String token){



        String jwt = token.split( " ")[1];
        Jwt jwtTokens = jwtDecoder.decode(jwt);
        String userID =jwtTokens.getClaims().get("userId").toString();

        System.out.println(userID);

        return studentService.getStudentMd(userID);


    }

    @GetMapping("/getStudentAttendanceStat")
    public StudentAttendanceStatDto getStudentAttendanceStat(@RequestHeader("Authorization") String token , @RequestParam(name = "module_id") Integer moduleId){
        String jwt = token.split( " ")[1];
        Jwt jwtTokens = jwtDecoder.decode(jwt);
        String userID =jwtTokens.getClaims().get("userId").toString();
        return studentService.getStudentAttendanceStat(userID, moduleId);

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
