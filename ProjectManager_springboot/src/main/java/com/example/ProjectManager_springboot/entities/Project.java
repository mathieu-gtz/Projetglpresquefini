package com.example.ProjectManager_springboot.entities;

import com.example.ProjectManager_springboot.dto.ProjectDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Date startDate;

    private Date endDate;

    @OneToMany(mappedBy = "project")
    private Set<UserProject> userProjects;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private User manager;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Task> tasks;


    public ProjectDto getProjectDto() {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(id);
        projectDto.setName(name);
        projectDto.setDescription(description);
        projectDto.setStartDate(startDate);
        projectDto.setEndDate(endDate);
        projectDto.setManagerId(this.manager != null ? this.manager.getId() : null);

        return projectDto;
    }


}