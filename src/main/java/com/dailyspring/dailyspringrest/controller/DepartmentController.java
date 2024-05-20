package com.dailyspring.dailyspringrest.controller;

import com.dailyspring.dailyspringrest.entity.Department;
import com.dailyspring.dailyspringrest.error.DepartmentNotFoundException;
import com.dailyspring.dailyspringrest.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER= LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("inside saveDepartment of DepartmentCOntroller");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getAllDepartments(){
        LOGGER.info("Inside the fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/department/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside the findDepartmentById of DepartmentController");
        return departmentService.fetchDepartmentById(departmentId);
    }

    @DeleteMapping("department/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside the deleteDepartmentById of DepartmentController");
        return departmentService.deleteDepartmentById(departmentId);
    }

    @PutMapping("/department/{id}")
    public Department updateDepartment(@Valid @RequestBody Department department,@PathVariable Long id){
        LOGGER.info("Inside the updateDepartment of departmentController");
        return departmentService.updateDepartmentById(department,id);
    }

    @GetMapping("/department/name/{name}")
    public List<Department> findByDepartmentName(@PathVariable("name") String name){
        LOGGER.info("Inside the findByDepartmentName of departmentController");
        return departmentService.findByName(name);
    }
}
