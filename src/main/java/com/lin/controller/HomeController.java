package com.lin.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lin.model.Dish;
import com.lin.model.Opinion;
import com.lin.service.DishService;
import com.lin.utils.JavaMail;
import com.lin.validator.OpinionValidator;

@Controller
public class HomeController {
	
	private static final String DEFAULT_FROMEMAILID = "sixiang2016";
	private static final String DEFAULT_FROMEMAIL_PASSWORD = "niceFood";

	@Autowired
	private DishService dishService;

	@Autowired
	private OpinionValidator opinionValidator;

	@RequestMapping(value={"/", "/index"}, method=RequestMethod.GET)
	public String hello(Model model){

		List<Dish> deals = dishService.findAllDeals();
		List<Dish> allRmds = dishService.findAllChefRmd();
		List<Dish> chefRmdDishes = allRmds.stream().limit(4).collect(Collectors.toList());
		
		Opinion opinion = new Opinion();

		model.addAttribute("deals", deals);
		model.addAttribute("chefRmdDishes", chefRmdDishes);
		model.addAttribute("opinion", opinion);

		return "index";
	}
	
	@RequestMapping(value = "/opinion", method = RequestMethod.POST)
	public String sendOpinion(@ModelAttribute("opinion") Opinion opinion, BindingResult bindingResult) throws AddressException, MessagingException{
		opinionValidator.validate(opinion, bindingResult);
		
		if(bindingResult.hasErrors()){
			return "index";
		}
		
		JavaMail.generateAndSendEmail(DEFAULT_FROMEMAILID, DEFAULT_FROMEMAILID + "@gmail.com", DEFAULT_FROMEMAIL_PASSWORD, opinion.getName() + "'s opinion" + "---" + opinion.getEmail(), opinion.getContent());
		
		return "redirect:/index";
	}
	
	@RequestMapping("/gallery")
	public String photo(){
		return "photoGallery";
	}
}
