package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query
		String hql = "from Customer order by  lastName";
		Query<Customer> theQuery = currentSession.createQuery(hql, Customer.class);

		// execute query and get result list
		List<Customer> customers = theQuery.getResultList();

		// return the results
		return customers;
	}

	@Override
	public void saveCustomerDAO(Customer theCustomer) {

		// get the session
		Session theSession = sessionFactory.getCurrentSession();

		// save or update the customer to database
		theSession.saveOrUpdate(theCustomer);
		

	}

	@Override
	public void updateCustomerDAO(int id) {

	}

	@Override
	public void deleteCustomerDAO(int id) {

		// get the current hibernate session
		Session theSession = sessionFactory.getCurrentSession();

		// get the customer
		Customer tempCustomer = theSession.get(Customer.class, id);

		theSession.delete(tempCustomer);

	}

	@Override
	public Customer getCustomer(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// get the customer
		Customer tempCustomer = currentSession.get(Customer.class, theId);

		return tempCustomer;
	}

}
