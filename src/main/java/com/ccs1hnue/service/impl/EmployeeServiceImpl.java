package com.ccs1hnue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ccs1hnue.model.mongodb.Employee;
import com.ccs1hnue.repository.mongodb.EmployeeRepository;
import com.ccs1hnue.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee saveEmployee(Employee e) {
        return employeeRepository.save(e);
    }

    @Override
    public Employee findByEmployeeId(String employeeId) {
        return employeeRepository.findOne(employeeId);
    }

    @Override
    public void deleteByEmployeeId(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public void updateEmployee(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public boolean employeeExists(Employee e) {
        return employeeRepository.exists(Example.of(e));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteAll() {
        employeeRepository.deleteAll();
    }
}
