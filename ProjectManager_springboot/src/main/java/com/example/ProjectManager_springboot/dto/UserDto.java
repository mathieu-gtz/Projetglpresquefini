package com.example.ProjectManager_springboot.dto;

import com.example.ProjectManager_springboot.enums.UserRole;
import lombok.Data;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String password;

    private UserRole userRole;
}
