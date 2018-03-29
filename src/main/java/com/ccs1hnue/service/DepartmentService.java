package com.ccs1hnue.service;

import java.util.List;

import com.ccs1hnue.model.mongodb.Department;

public interface DepartmentService {
	Department saveDepartment(Department d);

    Department findByDepartmentId(String departmentId);

    void deleteByDepartmentId(String departmentId);

    void updateDepartment(Department d);

    boolean departmentExists(Department d);

    List<Department> findAll();

    void deleteAll();
}
