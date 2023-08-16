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

}
