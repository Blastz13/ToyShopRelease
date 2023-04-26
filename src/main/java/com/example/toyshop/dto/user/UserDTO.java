package com.example.toyshop.dto.user;

import com.example.toyshop.security.Role;
import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String email;
    private Role role;
}
