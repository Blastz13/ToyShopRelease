package com.example.toyshop.dto.user;

import lombok.Data;

@Data
public class UserCreateDTO {
    private String email;
    private String password;
    private String role;
}
