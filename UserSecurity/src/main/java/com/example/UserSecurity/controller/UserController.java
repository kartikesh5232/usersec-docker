package com.example.UserSecurity.controller;

import com.example.UserSecurity.DTO.RegisterUserDto;
import com.example.UserSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.example.UserSecurity.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/me")
    public ResponseEntity<User> authenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        User currentUser = (User) authentication.getPrincipal();

        return ResponseEntity.ok(currentUser);
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> allUsers() {
        List<User> users = userService.allUsers();
        users.stream().map(x -> x.getAuthorities()).forEach(System.out::println);
        return ResponseEntity.ok(users);
    }

    @GetMapping("/getuser")
    public ResponseEntity<Optional<User>> getusers(@RequestParam String email) {
        Optional<User> users = userService.getuser(email);
        return ResponseEntity.ok(users);
    }
}
