package com.example.ProjectManager_springboot.dto;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class ProjectDto {
    private Long id;

    private String name;

    private String description;

    private Date startDate;

    private Date endDate;

    private Long userId;

    private Long managerId;

}
