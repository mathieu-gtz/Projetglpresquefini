package com.example.ProjectManager_springboot.repositories;

import com.example.ProjectManager_springboot.entities.UserProject;
import com.example.ProjectManager_springboot.entities.UserProjectId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProjectRepository extends JpaRepository<UserProject, UserProjectId> {
}