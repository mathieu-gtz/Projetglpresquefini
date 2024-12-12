package com.example.ProjectManager_springboot.dto;

import lombok.Data;

@Data
public class AuthenticationRequest {

    private String email;

    private String password;

}
