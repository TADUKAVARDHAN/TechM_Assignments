package com.app.controller;


import com.app.model.Department;
import com.app.service.DepartmentService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAll() {
        return ResponseEntity.ok(service.getAllDepartments());
    }

    @PostMapping
    public ResponseEntity<Department> create(@RequestBody Department department) {
        Department created = service.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }
}