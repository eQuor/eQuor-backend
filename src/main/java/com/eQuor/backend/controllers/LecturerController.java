package com.eQuor.backend.controllers;

import com.eQuor.backend.dto.LecturerAttendaneStat;
import com.eQuor.backend.dto.OnlineStudentInfoDTO;
import com.eQuor.backend.services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/online")
    public List<OnlineStudentInfoDTO> getAllOnlineStudentBySessionId(@RequestParam(name = "session_id") String session_id){
        return lecturerService.getAllOnlineStudentBySessionId(Integer.parseInt(session_id));
    }
}
