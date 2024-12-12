package com.example.ProjectManager_springboot.services.admin;

import com.example.ProjectManager_springboot.dto.UserDto;
import com.example.ProjectManager_springboot.entities.User;

import java.util.List;

public interface AdminService {
    void changeUserRole(Long userId, String newRole);

    List<UserDto> getUser();
}
