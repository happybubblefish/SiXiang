package com.lin.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lin.model.Authority;
import com.lin.model.Customer;
import com.lin.model.UserCredentials;
import com.lin.service.AuthorityService;
import com.lin.service.CustomerService;
import com.lin.service.LoginService;
import com.lin.service.UserCredentialsService;
import com.lin.utils.PasswordChecker;
import com.lin.validator.CustomerValidator;
import com.lin.validator.UserCredentialsValidator;

@Controller
public class AccountController {
	
	@Autowired
	private UserCredentialsValidator userCredentialsValidator;
	
	@Autowired
	private AuthorityService authorityService;
	
	@Autowired
	private UserCredentialsService userCredentialsService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CustomerValidator customerValidator;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error){
		if(error != null){
			error = "Username or password is invalid.";
			model.addAttribute("error", error);
		}
		return "login";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String preRegistration(Model model){
		UserCredentials userCredentials = new UserCredentials();
		model.addAttribute("userCredentials", userCredentials);
		
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String postRegistration(@ModelAttribute("userCredentials") UserCredentials userCredentials, BindingResult bindingResult){
			
		userCredentialsValidator.validate(userCredentials, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "registration";
		}
		
		String password = userCredentials.getPassword();
		userCredentials.setPassword(bCryptPasswordEncoder.encode(password));
		Set<Authority> authoritySet = new HashSet<Authority>();
		userCredentials.setAuthorities(authoritySet);
		
		List<Authority> authorityList = authorityService.findByName("ROLE_USER");
		
		if(authorityList != null){
			Authority authority = authorityList.get(0);
			userCredentials.getAuthorities().add(authority);
			userCredentials.setEnabled(true);
			authority.getUserCredentials().add(userCredentials);
			
			//Set customer
			Customer customer = new Customer();
			customer.setEmail(userCredentials.getUsername());
			customer.setUserCredentials(userCredentials);
			
			//userCredentials must set customer, otherwise the same userCredentials will be considered as different thus will be saved twice in db.
			userCredentials.setCustomer(customer);
			customerService.save(customer);
			authorityService.save(authority);
		}
		
		loginService.autologin(userCredentials.getUsername(), password);
		
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String preEditProfile(Model model){
		String username = loginService.findLoggedInUsername();
		Customer customer = customerService.findCustomerByEmail(username);
		
		if(customer == null){
			return "login";
		}
		
		model.addAttribute("customer", customer);
		
		return "profile";
	}
	
	@RequestMapping(value = "/editcustomer", method = RequestMethod.POST)
	public String postEditProfile(@ModelAttribute("customer") Customer customer, BindingResult bindingResult){
		customerValidator.validate(customer, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "profile";
		}
		
		String username = loginService.findLoggedInUsername();
		Customer loggedInCustomer = customerService.findCustomerByEmail(username);
		loggedInCustomer.setFirstName(customer.getFirstName());
		loggedInCustomer.setLastName(customer.getLastName());
		loggedInCustomer.setPhone(customer.getPhone());
		loggedInCustomer.setAddress(customer.getAddress());
		
		customerService.save(loggedInCustomer);
				
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.GET)
	public String changePassword(Model model){
		String username = loginService.findLoggedInUsername();
		Customer customer = customerService.findCustomerByEmail(username);
		
		if(customer == null){
			return "login";
		}
		
		UserCredentials userCredentials = new UserCredentials();
		model.addAttribute("userCredentials", userCredentials);
		
		return "changePassword";
	}
	
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	public String postChangePassword(@ModelAttribute("usercredentials") UserCredentials userCredentials){
		
		if(!PasswordChecker.validate(userCredentials.getPassword())){
			return "changepassword";
		}
		
		String username = loginService.findLoggedInUsername();
		Customer customer = customerService.findCustomerByEmail(username);
		UserCredentials loggedInUserCredentials = customer.getUserCredentials();
		
		loggedInUserCredentials.setPassword(bCryptPasswordEncoder.encode(userCredentials.getPassword()));
		
		userCredentialsService.save(loggedInUserCredentials);
		
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			 session.invalidate();

			// This is for destroying spring session. session.invalidate() is
			// working for SessionAttribute("")
//			status.setComplete();
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}

		return "redirect:/index";
	}
}
