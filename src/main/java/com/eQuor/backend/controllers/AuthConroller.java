package com.eQuor.backend.controllers;

import com.eQuor.backend.dto.AuthenticationRequest;
import com.eQuor.backend.dto.AuthenticationResponse;
import com.eQuor.backend.dto.StudentInfoDto;
import com.eQuor.backend.services.AuthService;
import com.eQuor.backend.services.StudentService;
import com.eQuor.backend.services.TokenService;
import org.apache.coyote.Response;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Collection;
import java.util.List;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/auth")
@CrossOrigin
public class AuthConroller {
    private static final Logger LOG = LoggerFactory.getLogger(AuthConroller.class);

    private final TokenService tokenService;
    @Autowired
    private StudentService studentService;

    @Autowired
    private AuthService authService;

    public AuthConroller(TokenService tokenService){
        this.tokenService = tokenService;
    }

    @PostMapping("/token")
    @CrossOrigin
    public ResponseEntity<AuthenticationResponse> token(@RequestBody AuthenticationRequest authenticationRequest, Authentication authentication){
        LOG.debug("Token requested for user: '{}'", authentication.getName());
        String token = tokenService.generateToken(authentication);

        LOG.debug("Token granted '{}'", token);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        List<? extends GrantedAuthority> authorities = (List<? extends GrantedAuthority>) authentication.getAuthorities();
        System.out.println(authorities.get(0).toString().equals("ADMIN"));
        if (authenticationRequest.getRequestDeviceCode() == 1 && !authorities.get(0).toString().equals("STUDENT")){
            AuthenticationResponse authenticationResponse = new AuthenticationResponse(authentication.getName(), "[empty]",false, authentication.getAuthorities());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticationResponse);
        }
        AuthenticationResponse authenticationResponse = new AuthenticationResponse(authentication.getName(), token,true, authentication.getAuthorities());
        return ResponseEntity.ok().headers(headers).body(authenticationResponse);
    }

    @GetMapping("/getId")
    @CrossOrigin
    public StudentInfoDto getID(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Name is: "+authentication.getName());
        //System.out.println(authentication);

        //Access token
        Object principal = authentication.getPrincipal();
        Jwt jwt = (Jwt) principal;
        String token = jwt.getTokenValue();
//        String token = authentication.getCredentials().toString();
        System.out.println("meka tokan eka");




        //String token = authentication.getCredentials().toString();




        //Pass created values to dto object
//        StudentInfoDto studentInfoDto = new StudentInfoDto();
//        studentInfoDto.setUserName(authentication.getName());
//        studentInfoDto.setQrString(qrString);

        return studentService.updateQr(authentication);
    }

    @PostMapping("/RegisterWithQR")
    @CrossOrigin
    public ResponseEntity<AuthenticationResponse> registerWithQr(@RequestBody StudentInfoDto studentInfoDto){
        System.out.println("AAA");
        System.out.println(studentInfoDto.getUserName());
        AuthenticationResponse authenticationResponse = authService.loginWithQR(studentInfoDto);
        if (authenticationResponse.getIsAuth()){
            return ResponseEntity.ok().body(authenticationResponse);
        }
        else
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(authenticationResponse);
    }




}
