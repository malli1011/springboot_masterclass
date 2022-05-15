package com.springboot.masterclass.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.masterclass.entity.Department;
import com.springboot.masterclass.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
@ContextConfiguration(classes = {DepartmentController.class})
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
    void testSaveDepartment_withValidResponse() throws Exception {
        when(departmentService.saveDepartment(any(Department.class))).thenReturn(department);
        String requestStr = new ObjectMapper().writeValueAsString(department);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/department")
                        .content(requestStr)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String resultString = result.getResponse().getContentAsString();
        System.out.println(resultString);
        assertAll(
                () -> assertNotNull(resultString),
                () -> assertEquals(requestStr, resultString)
        );


    }

}