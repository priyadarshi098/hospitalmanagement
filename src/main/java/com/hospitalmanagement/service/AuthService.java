package com.hospitalmanagement.service;

import com.hospitalmanagement.dto.LoginDto;
import com.hospitalmanagement.entity.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public String logIn(LoginDto logindto){
        Authentication authentication =
                authenticationManager
                        .authenticate(
                                new UsernamePasswordAuthenticationToken(
                                        logindto.getEmail(),logindto.getPassword()
                                ));

        Users user = (Users)authentication.getPrincipal();
        return jwtService.generateAccessToken(user);
    }
}
