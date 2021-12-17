package com.nithi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nithi.Dao.CustomerDao;
import com.nithi.entity.Customer;
import com.nithi.service.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/customerPage")
	public String customerPage(@ModelAttribute("customerAtt") Customer customer ) {
		
		System.out.println("Welcome Customer");
		return "show-customer";
		
	}
	
	@PostMapping("/save-customer")
	public String saveCustomer(@ModelAttribute("customerAtt") Customer customer) {
		
		customerservice.saveCustomer(customer);
		return "redirect:/customerPage";
		
	}

}
