package com.nithi.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	//id, item_name, price ,id_menu_detail
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "item_name")
	private String itemName;
	
	@Column(name = "price")
	private double price;

	@OneToOne(cascade = CascadeType.ALL)
	//@OneToOne
	@JoinColumn(name = "id_menu_detail")
	private MenuDetail menuDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public MenuDetail getMenuDetails() {
		return menuDetails;
	}

	public void setMenuDetails(MenuDetail menuDetails) {
		this.menuDetails = menuDetails;
	}

	@Override
	public String toString() {
		return "Menu [id=" + id + ", itemName=" + itemName + ", price=" + price + ", menuDetails=" + menuDetails + "]";
	}
	
	

	
	

	

	
	
	
	
}
