package com.eQuor.backend.controllers;

import com.eQuor.backend.dto.AuthenticationResponse;
import com.eQuor.backend.services.TokenService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthController {
    private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);

    private final TokenService tokenService;

    public AuthController(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    @CrossOrigin
    public ResponseEntity<AuthenticationResponse> token(Authentication authentication){
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);
        LOG.debug("Token granted '{}'", token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        System.out.println(authentication.getAuthorities());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(authentication.getName(), token,true, authentication.getAuthorities());
        return ResponseEntity.ok().headers(headers).body(authenticationResponse);
    }
}
