package com.dimas.oracleapi.projetooraclexespringboot.controller;

import com.dimas.oracleapi.projetooraclexespringboot.dto.LoginRequest;
import com.dimas.oracleapi.projetooraclexespringboot.dto.LoginResponse;
import com.dimas.oracleapi.projetooraclexespringboot.security.JwtService;
import com.dimas.oracleapi.projetooraclexespringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtService jwtService;
    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        String token = jwtService.authenticate( request.getEmail(), request.getSenha());
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
