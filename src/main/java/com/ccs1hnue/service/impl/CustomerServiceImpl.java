package com.ccs1hnue.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ccs1hnue.model.mysql.Customer;
import com.ccs1hnue.repository.mysql.CustomerRepository;
import com.ccs1hnue.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer s)
	{
		return customerRepository.save(s);
	}
	
	@Override
	public Iterable<Customer> findAll()
	{
		return customerRepository.findAll();
	}
	
	@Override
	public Optional<Customer> findById(long id)
	{
		return customerRepository.findById(id);
	}
	
	@Override
	public List<Customer> findByLastName(String lastName)
	{
		return customerRepository.findByLastName(lastName);
	}
}
