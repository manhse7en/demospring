package com.ccs1hnue.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ccs1hnue.model.mongodb.Employee;

public interface EmployeeRepository extends MongoRepository<Employee,String>{

	@Query("{ 'employeeId' : ?0 }")
	Employee findOne(String employeeId);

}
