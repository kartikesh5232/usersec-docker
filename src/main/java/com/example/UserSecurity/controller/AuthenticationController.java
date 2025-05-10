package com.example.UserSecurity.controller;

import com.example.UserSecurity.DTO.LoginResponse;
import com.example.UserSecurity.DTO.LoginUserDto;
import com.example.UserSecurity.DTO.RegisterUserDto;
import com.example.UserSecurity.entity.User;
import com.example.UserSecurity.entity.authority;
import com.example.UserSecurity.service.AuthenticationService;
import com.example.UserSecurity.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;

    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        User registeredUser = authenticationService.signup(registerUserDto);

        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {

        User authenticatedUser = authenticationService.authenticate(loginUserDto);
        System.out.println(authenticatedUser.getAuthorities().size());
        String jwtToken = jwtService.generateToken(authenticatedUser);
         Set<authority> authorities = new HashSet<>();
         authorities.addAll((Collection<authority>) authenticatedUser.getAuthorities());
         LoginResponse loginResponse = new LoginResponse().setToken(jwtToken)
                .setExpiresIn(jwtService.getExpirationTime())
                .setAuthorities(authorities);

        return ResponseEntity.ok(loginResponse);
    }
}

