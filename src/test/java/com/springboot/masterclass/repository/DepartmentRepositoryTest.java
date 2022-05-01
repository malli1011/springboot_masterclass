package com.springboot.masterclass.repository;

import com.springboot.masterclass.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class DepartmentRepositoryTest {
    /*
     * Use TestEntityManager as an alternative for Data.sql file for repository unit testing using h2 db.
     * */
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private DepartmentRepository repository;

    private Department department;
    @BeforeEach
    void setUp() {
         department = Department.builder()
                .departmentAddress("TEST")
                .departmentName("Test")
                .departmentCode("TD")
                .build();
        testEntityManager.persist(department);

    }

    @Test
    @DisplayName("Test JPA Repository find by id method")
    public void whenFindById_thenReturnDepartment() {
        var department1 = repository.findAll();
        Assertions.assertNotNull(department1);
        var dep = department1.get(0);
        Assertions.assertEquals(department.getDepartmentAddress(),dep.getDepartmentAddress());
        Assertions.assertTrue(dep.getDepartmentId()>0);

    }

    @Test
    @DisplayName("Test JPA Repository find by id method")
    public void whenSave_thenReturnDepartment() {
        var dep = repository.save(department);
        Assertions.assertNotNull(dep);
        Assertions.assertEquals(department.getDepartmentAddress(),dep.getDepartmentAddress());
        Assertions.assertTrue(dep.getDepartmentId()>0);
    }

}