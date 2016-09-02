package com.lin.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.model.Customer;
import com.lin.repository.CustomerRepository;
import com.lin.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		List<Customer> customers = customerRepository.findByEmail(email);
		
		if(customers.size() > 0){
			return customerRepository.findByEmail(email).get(0);
		}
		
		return null;
	}

}
