package com.example.ProjectManager_springboot.entities;

import com.example.ProjectManager_springboot.dto.TaskDto;
import com.example.ProjectManager_springboot.enums.TaskStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private Date dueDate;

    private String priority;

    private TaskStatus taskStatus;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;


    public TaskDto getTaskDto() {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(id);
        taskDto.setTitle(title);
        taskDto.setDescription(description);
        taskDto.setEmployeeName(user.getName());
        taskDto.setEmployee(user.getId());
        taskDto.setTaskStatus(taskStatus);
        taskDto.setDueDate(dueDate);
        taskDto.setPriority(priority);
        taskDto.setProject(project.getId());
        taskDto.setProjectName(project.getName());

        return taskDto;
    }
}
