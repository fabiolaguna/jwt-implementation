package edu.me.test.controllers;

import edu.me.test.models.dtos.responses.UserResponse;
import edu.me.test.services.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @DeleteMapping("/{employee-id}")
    public ResponseEntity<UserResponse> deleteEmployee(@PathVariable(value = "employee-id") Integer employeeId){

        return ResponseEntity.ok(UserResponse.fromUser(adminService.deleteEmployee(employeeId)));
    }
}
