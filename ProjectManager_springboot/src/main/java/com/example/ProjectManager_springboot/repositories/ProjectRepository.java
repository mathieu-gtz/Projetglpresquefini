package com.example.ProjectManager_springboot.repositories;

import com.example.ProjectManager_springboot.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByManagerId(Long managerId);
    Optional<Project> findById(Long projectId);
}
