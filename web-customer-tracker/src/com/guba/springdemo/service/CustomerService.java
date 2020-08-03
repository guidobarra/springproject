package com.guba.springdemo.service;

import java.util.List;

import com.guba.springdemo.entity.Customer;

public interface CustomerService {

	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int theId);
	
	public List<Customer> getCustomers();
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
}
