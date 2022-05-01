package com.springboot.masterclass.service;

import com.springboot.masterclass.entity.Department;
import com.springboot.masterclass.exceptions.DataNotFoundException;
import com.springboot.masterclass.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private static final Logger LOG = LoggerFactory.getLogger(DepartmentService.class);
    private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public List<Department> getAllDepartments(){
        return repository.findAll();
    }

    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    public Department getDepartmentById(long id) {
        Optional<Department> optional = repository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }else {
            throw new DataNotFoundException("Department not found with Id: "+id);
        }
    }

    public String deleteDepartmentById(Long id) {
        try {
            repository.deleteById(id);
            return "Successfully deleted the department with id: "+id;
        }catch (Exception e){
            LOG.error("Failed to delete department with id "+id,e);
            throw e;
        }


    }
}
