package com.guba.springdemo.dao;

import java.util.List;

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

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save the customer ... finally OK
		currentSession.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomer(int theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// get the customer by id
		Customer customer = currentSession.get(Customer.class, theId);
		return customer;
	}

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// create a query ... sort by last name
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", Customer.class);
		
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

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// deleting customer
		currentSession.delete(customer);
	}

}
