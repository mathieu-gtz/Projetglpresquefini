package com.example.ProjectManager_springboot.dto;

import com.example.ProjectManager_springboot.enums.TaskStatus;
import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {
    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private String priority;

    private TaskStatus taskStatus;

    private Long employee;

    private String employeeName;

    private Long project;

    private String projectName;


}
