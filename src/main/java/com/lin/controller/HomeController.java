package com.lin.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lin.model.Customer;
import com.lin.model.Dish;
import com.lin.model.JsonOrder;
import com.lin.model.OrderRecord;
import com.lin.model.UserCartCombo;
import com.lin.service.CustomerService;
import com.lin.service.DishService;
import com.lin.service.OrderRecordService;

@Controller
public class HomeController {

	@Autowired
	private DishService dishService;

	@Autowired
	private OrderRecordService orderRecordService;
	
	@Autowired
	private CustomerService customerService;

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
	
	@RequestMapping(value = "/saveshoppingcart", method = RequestMethod.POST)
	@ResponseBody
	public JsonOrder placeOrder(@RequestBody UserCartCombo ucc, HttpSession session) {
		OrderRecord order = new OrderRecord();
		order.setDishLines(ucc.getDishLines());
		order.setDate(new Date());
		orderRecordService.save(order);
		
		Customer customer = ucc.getCustomer();
		
		String email = customer.getEmail();
		
		JsonOrder jsonOrder = new JsonOrder();
		
		if(email.equals("") || email == null){
			jsonOrder.setStatus("Email cannot be empty.");
		}else{
			//Check whether the user with the same email is already exists.
			Customer anotherCustomer = customerService.findCustomerByEmail(email);
			
			if(anotherCustomer != null){
				anotherCustomer.getOrders().add(order);
				customerService.save(anotherCustomer);
			}else{
				customer.getOrders().add(order);
				customerService.save(customer);
			}			
			
			jsonOrder.setStatus("Your order has been sucessfully placed. We will deliver it when it get ready.");		
		}
		
		return jsonOrder;
	}
}
