package com.eQuor.backend.controllers;

import com.eQuor.backend.models.APIRequest;
import com.eQuor.backend.models.Staff;
import com.eQuor.backend.models.User;
import com.eQuor.backend.services.AdminService;
import com.eQuor.backend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/admin")
public class AdminController {
    private AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping("/getStaff")
    public List<Staff> getStaff(@RequestParam(required = false) String id) throws ExecutionException, InterruptedException {
        return adminService.getStaff(id);
    }

    @GetMapping("/getApiRequests")
    public List<APIRequest> getAPIRequests(@RequestParam(required = false) int filterByAcceptStatus) throws ExecutionException, InterruptedException {
        return adminService.getRequestAll(filterByAcceptStatus);
    }
    @GetMapping("/getApiRequest")
    public APIRequest getAPIRequest(@RequestParam(required = false) String id) throws ExecutionException, InterruptedException {
        return adminService.getAPIRequest(id);
    }
}
