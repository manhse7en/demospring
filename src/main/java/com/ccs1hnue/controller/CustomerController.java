package com.ccs1hnue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ccs1hnue.model.mongodb.Employee;
import com.ccs1hnue.model.mysql.Customer;
import com.ccs1hnue.service.CustomerService;

@RestController
@RequestMapping(value = "customer/")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public HttpEntity<?> saveCustomer(@RequestBody Customer c) {
		Customer customer = customerService.save(c);
		return new ResponseEntity<>(customer, HttpStatus.CREATED);
	}
	
}
