package com.lin.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.model.Customer;
import com.lin.model.Dish;
import com.lin.model.DishLine;
import com.lin.model.JsonOrder;
import com.lin.model.OrderRecord;
import com.lin.model.UserCartCombo;
import com.lin.model.UserCredentials;
import com.lin.service.CustomerService;
import com.lin.service.DishService;
import com.lin.service.LoginService;
import com.lin.service.OrderRecordService;
import com.lin.utils.JavaMail;

@Controller
public class HomeController {
	
	private final static String DEFAULT_PASSWORD = "123456";

	@Autowired
	private DishService dishService;

	@Autowired
	private OrderRecordService orderRecordService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private LoginService loginService;

	@RequestMapping(value={"/", "/index"}, method=RequestMethod.GET)
	public String hello(Model model){

		List<Dish> deals = dishService.findAllDeals();

		List<Dish> allRmds = dishService.findAllChefRmd();
		List<Dish> chefRmdDishes = allRmds.stream().limit(4).collect(Collectors.toList());

		model.addAttribute("deals", deals);
		model.addAttribute("chefRmdDishes", chefRmdDishes);

		return "index";
	}

	@RequestMapping("/menu")
	public String menu(Model model){
		List<Dish> beefDishes = dishService.findOneKindOfDishes("beef");
		List<Dish> porkDishes = dishService.findOneKindOfDishes("pork");
		List<Dish> chickenDishes = dishService.findOneKindOfDishes("chicken");
		List<Dish> seafoodsDishes = dishService.findOneKindOfDishes("seafoods");

		model.addAttribute("beefDishes", beefDishes);
		model.addAttribute("porkDishes", porkDishes);
		model.addAttribute("chickenDishes", chickenDishes);
		model.addAttribute("seafoodsDishes", seafoodsDishes);

		return "menu";
	}
	
	@RequestMapping("/shoppingcart")
	public String showShoppingCart(Model model, HttpSession session){
		Customer user = new Customer();
		model.addAttribute("user", user);
		
		return "shoppingcart";
	}
	
	//TODO: need Java Mail to sent customer an email.
	@RequestMapping(value = "/saveshoppingcart", method = RequestMethod.POST)
	@ResponseBody
	public JsonOrder placeOrder(@RequestBody UserCartCombo ucc, HttpSession session) throws AddressException, MessagingException {
		OrderRecord order = new OrderRecord();
		List<DishLine> dishLines = ucc.getDishLines();
		order.setDishLines(dishLines);
		
		double totalPrice = 0.0;
		for(DishLine dishLine : dishLines){
			totalPrice += dishLine.getPrice() * dishLine.getCount();
		}
		
		order.setTotalPrice(totalPrice);
		order.setDate(new Date());
		orderRecordService.save(order);
		
		Customer customer = ucc.getCustomer();
		
		String email = customer.getEmail();
		
		JsonOrder jsonOrder = new JsonOrder();
		
		if(email.equals("") || email == null){
			jsonOrder.setStatus("Email cannot be empty.");
		}else{
			//Check whether the user with the same email is already exists.
			Customer existedCustomer = customerService.findCustomerByEmail(email);
			
			if(existedCustomer != null){
				existedCustomer.getOrders().add(order);
				existedCustomer.setRewards(existedCustomer.getRewards() + order.getTotalPrice());
				
				existedCustomer.setFirstName(customer.getFirstName());
				existedCustomer.setLastName(customer.getLastName());
				existedCustomer.setPhone(customer.getPhone());
				existedCustomer.setAddress(customer.getAddress());

				customerService.save(existedCustomer);
			}else{
				customer.getOrders().add(order);
				customer.setRewards(order.getTotalPrice());
				
				//Only new customer will be automatically get registered.
				UserCredentials userCredentials = new UserCredentials();
				userCredentials.setUsername(email);
				
				//Set default password for the user.
				userCredentials.setPassword(bCryptPasswordEncoder.encode(DEFAULT_PASSWORD));
				userCredentials.setEnabled(true);
				customer.setUserCredentials(userCredentials);

				customerService.save(customer);
			}			
			
			jsonOrder.setStatus("Your order has been sucessfully placed. We will deliver it when it get ready.");	
			JavaMail.generateAndSendEmail("congls2007@yahoo.com", "lin.cong8066", "2012Babyborn");
		}
		
		return jsonOrder;
	}
	
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
