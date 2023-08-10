package com.eQuor.backend.controllers;


import com.eQuor.backend.models.User;
import com.eQuor.backend.services.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping("/create")
    public String getReq(@RequestBody User user) throws ExecutionException, InterruptedException {
        return userService.saveUserDetails(user);
    }


}
