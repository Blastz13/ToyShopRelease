package com.example.toyshop.security;

import com.example.toyshop.dto.user.UserCreateDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<Token> register(@RequestBody UserCreateDTO request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<Token> authenticate(@RequestBody UserCreateDTO request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

}
