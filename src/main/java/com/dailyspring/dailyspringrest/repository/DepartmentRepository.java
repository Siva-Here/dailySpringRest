package com.dailyspring.dailyspringrest.repository;

import com.dailyspring.dailyspringrest.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {
    public List<Department> findByDepartmentName(String name);

    public List<Department> findByDepartmentNameIgnoreCase(String name);

}
