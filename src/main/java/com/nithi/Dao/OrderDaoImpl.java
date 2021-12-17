package com.nithi.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nithi.entity.Order;

@Repository
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	@Transactional
	public void saveOrder(Order order) {
		
		System.out.println("Welcome to saveOrder DAO IMPL");
		Session session = sessionfactory.getCurrentSession();
		session.save(order);
		System.out.println("One Order is Saved ");

	}

}
