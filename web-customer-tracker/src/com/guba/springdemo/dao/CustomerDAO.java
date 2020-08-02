package com.guba.springdemo.dao;

import java.util.List;

import com.guba.springdemo.entity.Customer;

public interface CustomerDAO {

	public void saveCustomer(Customer customer);
	
	public Customer getCustomer();
	
	public List<Customer> getCustomers();
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);
	
}
