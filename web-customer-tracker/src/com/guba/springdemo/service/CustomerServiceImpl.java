package com.guba.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guba.springdemo.dao.CustomerDAO;
import com.guba.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	// need to inject the customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		
		customerDAO.saveCustomer(customer);
	}

	@Override
	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}

	@Override
	@Transactional // se encarga de iniciar y terminar la transaccion, "beginTransaction()" and "transactionCommit"
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}


	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		
		customerDAO.deleteCustomer(customer);
	}
	
	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {
		
		return customerDAO.searchCustomers(theSearchName);
	}

}
