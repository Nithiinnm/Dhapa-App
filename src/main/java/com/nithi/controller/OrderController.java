package com.nithi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nithi.Dao.MenuDao;
import com.nithi.Dao.OrderDao;
import com.nithi.entity.Menu;
import com.nithi.entity.Order;

@Controller
public class OrderController {
	
	@Autowired
	private MenuDao menuDao;
	
	@Autowired
	private OrderDao orderDao;
	
	@GetMapping("/orderPage")
	public String showOrderPage(Model model, Order order) {
		
		model.addAttribute("order", order);
		System.out.println("Welcome to Order Controller");
		List<Menu> menuItem = menuDao.getMenuItem();
		System.out.println("MenuItem in Order :"+menuItem);
		model.addAttribute("ListofMenu", menuItem);
		
		return "show-order-page";
		
	}
	
	//save-order

	@PostMapping("/save-order")
	@ResponseBody
	public String saveOrder(Order order) {
		
		System.out.println("Welcome to saveOrder");
		System.out.println("Order Entity  :"+order);
		orderDao.saveOrder(order);
		return "Order has been Placed";
		
	}
}
