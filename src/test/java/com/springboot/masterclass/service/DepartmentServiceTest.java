package com.springboot.masterclass.service;

import com.springboot.masterclass.entity.Department;
import com.springboot.masterclass.repository.DepartmentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(value = MockitoExtension.class)
class DepartmentServiceTest {

    @Mock
    DepartmentRepository repository;

    @InjectMocks
    DepartmentService service;

    @Test
    void getAllDepartments() {
        var department = new Department(1l, "test", "test", "test");
        when(repository.findAll()).thenReturn(List.of(department));
        var allDepartments = service.getAllDepartments();
        Assertions.assertAll(
                () -> assertEquals(1, allDepartments.size()),
                () -> assertEquals(department, allDepartments.get(0))
        );
    }

    @Test
    @DisplayName("Save Department object")
    void saveDepartment() {
        var department = new Department(1l, "test", "test", "test");
        when(repository.save(any(Department.class))).thenReturn(department);
        var dep = service.saveDepartment(new Department());
        assertEquals(department, dep);
    }

    @Test
    void getDepartmentById() {
    }

    @Test
    void deleteDepartmentById() {
    }
}