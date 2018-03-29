package com.ccs1hnue.service;

import java.util.List;
import java.util.Optional;

import com.ccs1hnue.model.mongodb.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee e);

    Employee findByEmployeeId(String employeeId);

    void deleteByEmployeeId(String employeeId);

    void updateEmployee(Employee e);

    boolean employeeExists(Employee e);

    List<Employee> findAll();

    void deleteAll();
}
