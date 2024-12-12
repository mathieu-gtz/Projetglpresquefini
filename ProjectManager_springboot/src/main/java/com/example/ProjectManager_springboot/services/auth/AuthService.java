package com.example.ProjectManager_springboot.services.auth;

import com.example.ProjectManager_springboot.dto.SignupRequest;
import com.example.ProjectManager_springboot.dto.UserDto;

public interface AuthService {

    UserDto signupUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
