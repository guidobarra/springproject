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
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public Customer getCustomer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional // se encarga de iniciar y terminar la transaccion, "beginTransaction()" and "transactionCommit"
	public List<Customer> getCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

}
