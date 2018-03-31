package com.ccs1hnue.model.mongodb;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.hateoas.ResourceSupport;

@Document(collection="employee")
public class Employee extends ResourceSupport implements Serializable{
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private int age;
	
	public Employee() {}

	public Employee(String employeeId, String firstName, String lastName, int age) {
		super();
		this.id = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public String getEmployeeId() {
		return id;
	}

	public void setEmployeeId(String employeeId) {
		this.id = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age="
				+ age + "]";
	}
	
	
}
