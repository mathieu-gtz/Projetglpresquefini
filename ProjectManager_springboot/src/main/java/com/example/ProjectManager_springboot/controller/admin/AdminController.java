package com.example.ProjectManager_springboot.controller.admin;


import com.example.ProjectManager_springboot.services.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;


    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/change-role/{userId}")
    public ResponseEntity<?> changeUserRole(@PathVariable Long userId, @RequestBody Map<String, String> request) {
        String newRole = request.get("newRole");
        adminService.changeUserRole(userId, newRole);
        Map<String, String> response = new HashMap<>();
        response.put("message", "User role updated successfully");
        return ResponseEntity.ok(response);
    }


    @GetMapping("/users")
    public ResponseEntity<?> getUsers() {
        return ResponseEntity.ok(adminService.getUser());
    }
}
