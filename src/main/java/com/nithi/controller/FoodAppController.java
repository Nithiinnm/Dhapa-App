package com.nithi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nithi.Dao.MenuDao;
import com.nithi.entity.Menu;

@Controller
public class FoodAppController {

	@Autowired
	private MenuDao menuDao;
	
	@GetMapping("/") 
	public String homePage() {
		System.out.println("Welcome to Home Page");
		return "home-page";
	}
	
	
	@GetMapping("/showMenuPage")
	public String showMenuPage(Model model) {
		System.out.println("Welcome to Controller");
		List<Menu> menuItem = menuDao.getMenuItem();
		System.out.println("menuItem  :" + menuItem);
		model.addAttribute("menu", menuItem);
		return "menu-page";
		
	}
	
	@GetMapping("/showAddMenuPage")
	public String showAddMenu(Menu menu,Model model) {
		
		System.out.println("Menu in Show Add Menu Page  >>>>>"+menu);
		model.addAttribute("addmenu", menu);
		return "add-menu-page";
		
	}
	
	@PostMapping("/save-menu")
	public String saveMenuItems(@ModelAttribute("addmenu") Menu menu) {
		
		System.out.println("Inside Save-menu");
		String itemName = menu.getItemName();
		double price = menu.getPrice();
		if(itemName != null && price!=0) {
		menuDao.saveMenuItems(menu);
	//	model.addAttribute("addedmenu", menu);
	//	return "save-menu-page";
		return "redirect:/showAddMenuPage";
		}
		return "error-page";
		
		
	}
	
	@GetMapping("/thankyou")
	public String thankyou(@ModelAttribute("addmenu") Menu menu) {
		return "save-menu-page";
		
	}
	
	@GetMapping("/deleteMenuItem")
	public String deleteItem(@RequestParam("itemid") int itemid) {
		
		System.out.println("itemId :"+itemid);
		menuDao.deleteItem(itemid);
		return "redirect:/showMenuPage";
		
	}
	
	@GetMapping("/updateMenuItem/{id}")
	public String updateMenuitem(@PathVariable("id") int id, Model model) {

		System.out.println("Update Menu and Id is >>>>"+id);
		Menu menuById = menuDao.getMenuById(id);
		model.addAttribute("addmenu", menuById);
		return"add-menu-page";
	}
	
	@GetMapping("/searchMenuItem")
	public String searchItem(@RequestParam("itemName") String itemName, Model model) {
		
		System.out.println("itemName :"+itemName);
		List<Menu> searchItem = menuDao.searchItem(itemName);
		model.addAttribute("menu", searchItem);
		return"menu-page";
	}
	
}
