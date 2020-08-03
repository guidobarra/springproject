package com.guba.springdemo.dao;

import java.util.List;

import com.guba.springdemo.entity.Customer;

public interface CustomerDAO {

	public void saveCustomer(Customer customer);
	
	public Customer getCustomer(int theId);
	
	public List<Customer> getCustomers();
		
	public void deleteCustomer(Customer customer);

	public List<Customer> searchCustomers(String theSearchName);
	
}
