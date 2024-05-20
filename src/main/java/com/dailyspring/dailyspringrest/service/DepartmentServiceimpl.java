package com.dailyspring.dailyspringrest.service;

import com.dailyspring.dailyspringrest.entity.Department;
import com.dailyspring.dailyspringrest.error.DepartmentNotFoundException;
import com.dailyspring.dailyspringrest.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceimpl implements DepartmentService{

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return (departmentRepository.findAll());
    }

    @Override
    public Department fetchDepartmentById(Long id) throws DepartmentNotFoundException {

        Optional<Department> department =departmentRepository.findById(id);
        if(department.isEmpty()){
            throw new DepartmentNotFoundException("Department Not Available...");
        }
        return department.get();
    }

    @Override
    public String deleteDepartmentById(Long departmentId) {

        departmentRepository.deleteById(departmentId);
        return "Department deleted successfully";
    }

    @Override
    public Department updateDepartmentById(Department department, Long id) {
        Department depDB=departmentRepository.findById(id).get();

        if(Objects.nonNull(department.getDepartmentName())
        &&
        !"".equalsIgnoreCase(department.getDepartmentName())
        ){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentCode())
                &&
                !"".equalsIgnoreCase(department.getDepartmentCode())
        ){
            depDB.setDepartmentCode(department.getDepartmentCode());
        }

        if(Objects.nonNull(department.getDepartmentAddress())
                &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())
        ){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        return departmentRepository.save(depDB);
    }

    @Override
    public List<Department> findByName(String name) {

        return departmentRepository.findByDepartmentNameIgnoreCase(name);
    }
}
