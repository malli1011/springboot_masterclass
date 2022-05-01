package com.springboot.masterclass.controller;

import com.springboot.masterclass.entity.Department;
import com.springboot.masterclass.service.DepartmentService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService deptService;

    public DepartmentController(DepartmentService deptService) {
        this.deptService = deptService;
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return deptService.getAllDepartments();
    }

    @PostMapping
    public Department saveDepartment(@Valid @RequestBody Department department) {
        return deptService.saveDepartment(department);
    }


    @GetMapping(value = "/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return deptService.getDepartmentById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
            return deptService.deleteDepartmentById(id);
    }
}
