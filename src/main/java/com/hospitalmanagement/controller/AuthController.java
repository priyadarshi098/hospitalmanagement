package com.hospitalmanagement.controller;

import com.hospitalmanagement.dto.LoginDto;
import com.hospitalmanagement.dto.SignUpDto;
import com.hospitalmanagement.dto.UserDto;
import com.hospitalmanagement.service.AuthService;
import com.hospitalmanagement.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import jakarta.servlet.http.Cookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authservice;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signUp(@RequestBody SignUpDto signupdto){
        return ResponseEntity.ok(userService.signUp(signupdto));
    }

    @PostMapping("/login")
    public ResponseEntity<String> logIn(
            @RequestBody LoginDto logindto,
            HttpServletRequest request,
            HttpServletResponse response){
        String token = authservice.logIn(logindto);
        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return ResponseEntity.ok(token);
    }
}
