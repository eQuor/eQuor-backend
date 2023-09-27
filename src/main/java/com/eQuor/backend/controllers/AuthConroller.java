package com.eQuor.backend.controllers;

import com.eQuor.backend.dto.AuthenticationResponse;
import com.eQuor.backend.services.StudentService;
import com.eQuor.backend.services.TokenService;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/auth")
public class AuthConroller {
    private static final Logger LOG = LoggerFactory.getLogger(AuthConroller.class);

    private final TokenService tokenService;
    @Autowired
    private StudentService studentService;

    public AuthConroller(TokenService tokenService){
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



//    @PostMapping("/getId")
//    @CrossOrigin
//    public String getID(Authentication authentication){
//
//        System.out.println("Name is: "+authentication.getName());
//        return "aa";
//    }
    @GetMapping("/getId")
    @CrossOrigin
    public String getID(Authentication authentication){

        System.out.println("Name is: "+authentication.getName());
        System.out.println(authentication);
        //return "aa";

        return studentService.updateQr(authentication);
//        String name = authentication.getName();
       // return authentication.getName();





    }

}
