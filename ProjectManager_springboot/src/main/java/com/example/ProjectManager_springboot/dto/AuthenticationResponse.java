package com.example.ProjectManager_springboot.dto;

import com.example.ProjectManager_springboot.enums.UserRole;
import lombok.Data;

@Data
public class AuthenticationResponse {

    private String jwt;

    private Long userId;

    private UserRole userRole;
}
