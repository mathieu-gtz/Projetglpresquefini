package com.example.ProjectManager_springboot.repositories;

import com.example.ProjectManager_springboot.entities.User;
import com.example.ProjectManager_springboot.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String username);

    Optional<User> findByUserRole(UserRole userRole);

    List<User> findAllByUserRole(UserRole userRole);
}
