package com.guba.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.guba.springdemo.entity.Customer;

@Repository // DAO
public class CustomerDAOImpl implements CustomerDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory; 

	@Override
	public void saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Customer getCustomer() {
		return null;
	}

	@Override
	@Transactional // se encarga de iniciar y terminar la transaccion, "beginTransaction()" and "transactionCommit"
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> customersResult = theQuery.getResultList();
		
		// return the results
		return customersResult;
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
