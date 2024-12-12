package com.example.ProjectManager_springboot.services.manager;

import com.example.ProjectManager_springboot.dto.ProjectDto;
import com.example.ProjectManager_springboot.dto.TaskDto;
import com.example.ProjectManager_springboot.dto.UserDto;

import java.util.List;

public interface ManagerService {

    ProjectDto createProject(ProjectDto projectDto);

    TaskDto createTask(Long projectId, TaskDto taskDto);

    void deleteTask(Long id);

    List<ProjectDto> getProjectsByManager(Long managerId);

    List<TaskDto> getTasksByProjectId(Long projectId);

    TaskDto updateTask(Long id, TaskDto taskDTO);

    ProjectDto getProjectById(Long id);

    List<UserDto> getAllEmployees();

    TaskDto getTaskById(Long id);

    List<UserDto> getAllManagers();
}
