package com.example.toyshop.controller;

import com.example.toyshop.dto.user.UserCreateDTO;
import com.example.toyshop.dto.user.UserDTO;
import com.example.toyshop.dto.user.UserDetailDTO;
import com.example.toyshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<UserDetailDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findByIdDto(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/{id}/update")
    public ResponseEntity<UserDetailDTO> update(@PathVariable Long id, @RequestBody UserCreateDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
