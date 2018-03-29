package com.ccs1hnue.repository.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.ccs1hnue.model.mongodb.Department;

public interface DepartmentRepository extends MongoRepository<Department,String>{
	@Query("{ 'departmentId' : ?0 }")
	Department findOne(String departmentId);
}
