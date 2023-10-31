package com.eQuor.backend.controllers;

import com.eQuor.backend.dto.AdminMemberCount;
import com.eQuor.backend.dto.LecturerAttendaneStat;
import com.eQuor.backend.services.AdminService;
import com.eQuor.backend.services.LecturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/admin")
@CrossOrigin
public class AdminController {

    @Autowired
    private AdminService adminService;


    @GetMapping("/adminDashboard/")

    public AdminMemberCount getMemberCount() {

        return adminService.getTotalMembers();
    }
}
