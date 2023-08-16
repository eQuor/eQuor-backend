package com.eQuor.backend.controllers;

import com.eQuor.backend.dto.AuthenticationResponse;
import com.eQuor.backend.services.AuthenticationService;
import org.springframework.web.bind.annotation.*;
import com.eQuor.backend.dto.AuthenticationRequest;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/auth")

public class AuthenticationController {
    private final AuthenticationService authenticationService;
    public AuthenticationController(AuthenticationService authenticationService){
        this.authenticationService = authenticationService;
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest authenticationRequest) throws ExecutionException, InterruptedException {
        return authenticationService.login(authenticationRequest);
    }

}
