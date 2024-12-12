package com.example.ProjectManager_springboot.entities;

import com.example.ProjectManager_springboot.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
public class UserProject {

    @EmbeddedId
    private UserProjectId id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("projectId")
    private Project project;

    @Enumerated(EnumType.STRING)
    private UserRole role;
}
