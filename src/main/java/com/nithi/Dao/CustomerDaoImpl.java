package com.nithi.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nithi.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		Session session = sessionfactory.getCurrentSession();
		session.save(customer);
	}

}
