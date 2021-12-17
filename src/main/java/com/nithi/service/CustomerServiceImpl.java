package com.nithi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nithi.Dao.CustomerDao;
import com.nithi.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public void saveCustomer(Customer customer) {

		customerDao.saveCustomer(customer);

	}

}
