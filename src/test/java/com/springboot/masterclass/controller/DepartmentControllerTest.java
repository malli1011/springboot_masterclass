package com.springboot.masterclass.controller;

import com.springboot.masterclass.entity.Department;
import com.springboot.masterclass.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentAddress("TEST")
                .departmentName("Test")
                .departmentCode("TD")
                .departmentId(1l)
                .build();
    }

    @Test
    void testSaveDepartment_withValidResponse() {
        when(departmentService.saveDepartment(any(Department.class))).thenReturn(department);

    }

}