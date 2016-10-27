package com.lin.model;

import java.util.List;

public class UserCartCombo {
	private Customer customer;
	private List<DishLine> dishLines;
	
//	private String firstName;
//	
//	private String lastName;
//	
//	private String email;
//	
//	private String phone;
//	
//	private String address;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public List<DishLine> getDishLines() {
		return dishLines;
	}
	
	public void setDishLines(List<DishLine> dishLines) {
		this.dishLines = dishLines;
	}
}
