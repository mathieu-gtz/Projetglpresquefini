package com.example.ProjectManager_springboot.services.userProject;

import com.example.ProjectManager_springboot.entities.UserProject;
import com.example.ProjectManager_springboot.entities.UserProjectId;
import com.example.ProjectManager_springboot.enums.UserRole;
import com.example.ProjectManager_springboot.repositories.UserProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProjectService {

    private final UserProjectRepository userProjectRepository;

    public void assignUserToProject(Long userId, Long projectId, UserRole role) {
        UserProject userProject = new UserProject();
        userProject.setId(new UserProjectId(userId, projectId));
        userProject.setRole(role);
        userProjectRepository.save(userProject);
    }
}
