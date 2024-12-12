package com.example.ProjectManager_springboot.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class UserProjectId implements Serializable {

    private Long userId;
    private Long projectId;

    public UserProjectId(Long userId, Long projectId) {
        this.userId = userId;
        this.projectId = projectId;
    }
}