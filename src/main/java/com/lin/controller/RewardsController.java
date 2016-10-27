package com.lin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lin.model.Customer;
import com.lin.service.CustomerService;
import com.lin.service.LoginService;

@Controller
public class RewardsController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/rewards", method = RequestMethod.GET)
	public String getRewards(Model model){
		String username = loginService.findLoggedInUsername();
		
		Customer customer = customerService.findCustomerByEmail(username);
		if(customer == null){
			return "login";
		}else{
			double rewards = customer.getRewards();
			model.addAttribute("rewards", rewards);
			return "rewards";
		}
	}
}
