package com.ccs1hnue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ccs1hnue.model.mongodb.Department;
import com.ccs1hnue.repository.mongodb.DepartmentRepository;
import com.ccs1hnue.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department d) {
        return departmentRepository.save(d);
    }

    @Override
    public Department findByDepartmentId(String departmentId) {
        return departmentRepository.findOne(departmentId);
    }

    @Override
    public void deleteByDepartmentId(String departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public void updateDepartment(Department d) {
        departmentRepository.save(d);
    }

    @Override
    public boolean departmentExists(Department d) {
        return departmentRepository.exists(Example.of(d));
    }

    @Override
    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void deleteAll() {
        departmentRepository.deleteAll();
    }
}
