package com.lin.controller;

import java.util.Date;
import java.util.List;

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
import com.lin.model.DishLine;
import com.lin.model.JsonOrder;
import com.lin.model.OrderRecord;
import com.lin.model.UserCartCombo;
import com.lin.model.UserCredentials;
import com.lin.service.CustomerService;
import com.lin.service.LoginService;
import com.lin.service.OrderRecordService;
import com.lin.utils.JavaMail;

@Controller
public class ShoppingCartController {
	
	private final static String DEFAULT_PASSWORD = "123456";
	private final static String DEFAULT_SUBJECT = "Your order from SiXiang";
	private final static String DEFAULT_CONFIRMATION_CONTENT = "Thank you for your order. We will deliver your order ASAP when it get ready. "
			+ "<br><br> Meanwhile, we set up an account for you when you placed the order in order to send you the rewards. The username is email that "
			+ "you used to order food and the default password is '123456'. <br><br> Please go to our website to update your password "
			+ "ASAP. <br><br>Best regards, <br>SiXiang group";
	private static final String DEFAULT_TOEMAIL = "lin.cong8066@gmail.com";
	private static final String DEFAULT_FROMEMAILID = "sixiang2016";
	private static final String DEFAULT_FROMEMAIL_PASSWORD = "niceFood";
	
	@Autowired
	private OrderRecordService orderRecordService;
	
	@Autowired
	private LoginService loginService;

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@RequestMapping(value = "/shoppingcart", method = RequestMethod.GET)
	public String showShoppingCart(Model model, HttpSession session) {
		String username = loginService.findLoggedInUsername();
		
		Customer customer = customerService.findCustomerByEmail(username);
		if(customer == null){
			return "login";
		}
		
//		Customer user = new Customer();
//		model.addAttribute("user", user);

		return "shoppingcart";
	}

	@RequestMapping(value = "/saveshoppingcart", method = RequestMethod.POST)
	@ResponseBody
	public JsonOrder placeOrder(@RequestBody UserCartCombo ucc, HttpSession session)
			throws AddressException, MessagingException {
		OrderRecord order = new OrderRecord();
		List<DishLine> dishLines = ucc.getDishLines();
		order.setDishLines(dishLines);

		double totalPrice = 0.0;
		for (DishLine dishLine : dishLines) {
			totalPrice += dishLine.getPrice() * dishLine.getCount();
		}

		order.setTotalPrice(totalPrice);
		order.setDate(new Date());
		orderRecordService.save(order);

		Customer customer = ucc.getCustomer();
		String email = customer.getEmail();

		JsonOrder jsonOrder = new JsonOrder();

		if (email.equals("") || email == null) {
			jsonOrder.setStatus("Email cannot be empty.");
		} else {
			// Check whether the user with the same email is already exists.
			Customer existedCustomer = customerService.findCustomerByEmail(email);

			if (existedCustomer != null) {
				existedCustomer.getOrders().add(order);
				existedCustomer.setRewards(existedCustomer.getRewards() + order.getTotalPrice());

				existedCustomer.setFirstName(customer.getFirstName());
				existedCustomer.setLastName(customer.getLastName());
				existedCustomer.setPhone(customer.getPhone());
				existedCustomer.setAddress(customer.getAddress());

				customerService.save(existedCustomer);
			} else {
				customer.getOrders().add(order);
				customer.setRewards(order.getTotalPrice());

				// Only new customer will be automatically get registered.
				UserCredentials userCredentials = new UserCredentials();
				userCredentials.setUsername(email);

				// Set default password for the user.
				userCredentials.setPassword(bCryptPasswordEncoder.encode(DEFAULT_PASSWORD));
				userCredentials.setEnabled(true);
				customer.setUserCredentials(userCredentials);

				customerService.save(customer);
			}

			jsonOrder.setStatus("Your order has been sucessfully placed. We will deliver it when it get ready.");

			String greeting = "Dear " + customer.getFirstName() + ",<br>";
			JavaMail.generateAndSendEmail(DEFAULT_FROMEMAILID, DEFAULT_TOEMAIL, DEFAULT_FROMEMAIL_PASSWORD, DEFAULT_SUBJECT, greeting + DEFAULT_CONFIRMATION_CONTENT);
		}

		return jsonOrder;
	}

}
