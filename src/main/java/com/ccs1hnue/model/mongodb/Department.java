package com.ccs1hnue.model.mongodb;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.ResourceSupport;

@Document(collection="department")
public class Department extends ResourceSupport implements Serializable{

	@Id
    private String departmentId;
    private String name;
    private String description;
    @DBRef
    private List<Employee> employees;
	
    public Department() {}
    
    public Department(String departmentId, String name, String description, List<Employee> employees) {
		super();
		this.departmentId = departmentId;
		this.name = name;
		this.description = description;
		this.employees = employees;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", description=" + description
				+ ", employees=" + employees + "]";
	}
    
    
}
