package com.eQuor.backend.controllers;

import com.eQuor.backend.dto.LecturerAttendaneStat;
import com.eQuor.backend.dto.OnlineStudentInfoDTO;
import com.eQuor.backend.dto.SessionAttendanceDto;
import com.eQuor.backend.models.Module;
import com.eQuor.backend.models.Sessions;
import com.eQuor.backend.models.Student;
import com.eQuor.backend.repositories.ModuleRepository;
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



    @GetMapping("/generateQrSequence/{sessionId}")
    public String generateQrSequence(@PathVariable int sessionId) {

        System.out.println("inside generateQr");

        return lecturerService.generateQrSequence(sessionId);
    }
    @GetMapping("/getModules")
    public List<Module> getModule(){
        return lecturerService.getModules();
    }


    //Get module details for a lecturer by giving the id

    @Autowired
    private ModuleRepository moduleRepository;
    @GetMapping("/getModuleDetailsById/{moduleId}")
    public Module getUserById(@PathVariable int moduleId){

        Module module = moduleRepository.findById(moduleId);
        return module;

    }

    //Get all sessions of a module by giving the module id
//    @Autowired
//
//    private SessionService sessionService;

//    @GetMapping("/getAllSessionDetailsByModuleId/{moduleId}")
//    public List<Sessions> getAllSessionDetailsByModuleId(@PathVariable int moduleId){
//        return lecturerService.getAllSessionsByModuleId(moduleId);
//    }

    //Get all sessions of a module by giving the module id


    @GetMapping("/getAllSessionsDetailsByModuleId/{moduleId}")
    public List<Sessions> getAllSessionsByModuleId(@PathVariable Integer moduleId) {
        return lecturerService.getAllSessionsByModuleId(moduleId);
    }

    @GetMapping("/getSessionAttendance")
    public List<SessionAttendanceDto> getSessionAttendance(@RequestParam(name = "session_id") Integer session_id){
        return lecturerService.getSessionAttendance(session_id);

    }




}
