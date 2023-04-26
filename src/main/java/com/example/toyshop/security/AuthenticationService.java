package com.example.toyshop.security;

import com.example.toyshop.dto.user.UserCreateDTO;
import com.example.toyshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public Token register(UserCreateDTO userRegistryDTO) {
        var user = userService.save(userRegistryDTO);
        var jwtToken = jwtService.generateToken(user);
        return new Token(jwtToken);
    }

    public Token authenticate(UserCreateDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword(),
                        new ArrayList<>()
                )
        );
        var user = userService.getByEmail(request.getEmail());
        return new Token(jwtService.generateToken(user));
    }
}
