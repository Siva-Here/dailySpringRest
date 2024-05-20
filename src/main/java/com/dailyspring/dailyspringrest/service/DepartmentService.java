package com.dailyspring.dailyspringrest.service;

import com.dailyspring.dailyspringrest.entity.Department;
import com.dailyspring.dailyspringrest.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {

    public Department saveDepartment(Department department);

    public List<Department> fetchDepartmentList();

    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException;

    public String deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Department department, Long id);

    public  List<Department> findByName(String name);

}
