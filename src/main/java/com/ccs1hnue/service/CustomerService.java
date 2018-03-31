package com.ccs1hnue.service;

import java.util.List;
import java.util.Optional;

import com.ccs1hnue.model.mysql.Customer;

public interface CustomerService {

	Customer save(Customer s);

	Iterable<Customer> findAll();

	Optional<Customer> findById(long id);

	List<Customer> findByLastName(String lastName);

}