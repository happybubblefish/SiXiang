package com.lin.service;

import com.lin.model.Customer;

public interface CustomerService {
	
	Customer save(Customer user);
	
	Customer findCustomerByEmail(String email);
}
