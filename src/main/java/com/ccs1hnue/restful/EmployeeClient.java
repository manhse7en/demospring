package com.ccs1hnue.restful;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ccs1hnue.model.mongodb.Employee;

public class EmployeeClient {
	RestTemplate restTemplate;
	
	public EmployeeClient()
	{
		restTemplate = new RestTemplate();
	}
	
	public void postReq()
	{
		System.out.println("Begin /POST request!");
		String postUrl = "http://localhost:8080/api/employee/save";
		Employee emp = new Employee("1","Nguyễn Đức","Mạnh",25);
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl,emp, String.class);
	}
	
	public void getReq()
	{
		System.out.println("Begin /GET request!");
		String getUrl = "http://localhost:8080/api/employee/1";
		ResponseEntity<Employee> getResponse = restTemplate.getForEntity(getUrl, Employee.class);
		if(getResponse.getBody() != null)
		{
			System.out.println("Response for Get Request: " + getResponse.getBody().toString());	
		}
		else
		{
			System.out.println("Response for Get Request: NULL");
		}
	}
	
	public void putReq()
	{
		System.out.println("Begin /PUT request!");
		String putUrl = "http://localhost:8080/api/employee/1";
		Employee emp = new Employee("1","Nguyễn Đức","Mạnh",26);
		restTemplate.put(putUrl, emp);
	}
	
	public void deleteReq()
	{
		System.out.println("Begin /DELETE request!");
		String deleteUrl = "http://localhost:8080/api/employee/1";
		restTemplate.delete(deleteUrl);
	}
}
