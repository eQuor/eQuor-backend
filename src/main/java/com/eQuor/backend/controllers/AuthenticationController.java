package com.eQuor.backend.controllers;

import com.eQuor.backend.services.AuthenticationService;
import com.eQuor.backend.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eQuor.backend.models.AuthenticationResponse;
import com.eQuor.backend.models.AuthenticationRequest;
import com.eQuor.backend.models.RegisterRequest;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public String register(@RequestBody User user) throws ExecutionException, InterruptedException {
        return authenticationService.register(user);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
