package com.nithi.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "orders")
public class Order {

	
	//ord_id, menu_id, ord_type, ord_quantity, ord_date, cus_id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ord_id")
	private int id;
	
	@Column(name = "ord_type")
	private String ordertype;
	
	@Column(name = "ord_quantity")
	private int quantity;
	
	@Column(name = "ord_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = ("dd-MM-yyyy"))
	private Date date;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "menu_id")
	private Menu menuid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cus_id")
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Menu getMenuid() {
		return menuid;
	}

	public void setMenuid(Menu menuid) {
		this.menuid = menuid;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", ordertype=" + ordertype + ", quantity=" + quantity + ", date=" + date
				+ ", menuid=" + menuid + ", customer=" + customer + "]";
	}



	

	
	
}
