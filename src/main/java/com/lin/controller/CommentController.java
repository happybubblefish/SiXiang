package com.lin.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lin.model.Comment;
import com.lin.model.Customer;
import com.lin.model.Dish;
import com.lin.service.CommentService;
import com.lin.service.CustomerService;
import com.lin.service.DishService;
import com.lin.service.LoginService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private DishService dishService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/comments", method = RequestMethod.GET)
	public String allCommentsByDish(@RequestParam(value = "dishId", required = false) Long dishId, Model model){
		
		Dish dish = dishService.findOne(dishId);
		Comment comment = new Comment();
		
		List<Comment> comments = null;
		
		if(dishId == null){
			comments = commentService.findAllComments();
		}else{
			comments = commentService.findAllCommentByDishId(dishId);
		}
		
		model.addAttribute("comment", comment);
		model.addAttribute("comments", comments);
		model.addAttribute("dish", dish);
		
		return "comments";
	}
	
	@RequestMapping(value = "/addcomment", method = RequestMethod.POST)
	public String postAddComment(@ModelAttribute("comment") Comment comment, BindingResult bindingResult){
		String username = loginService.findLoggedInUsername();
		if(username.equals("anonymousUser")){
			return "login";
		}
		
		Customer customer = customerService.findCustomerByEmail(username);
		
		Dish dish = dishService.findOne(comment.getDish().getId());
		
		comment.setCustomer(customer);
		comment.setCommentDate(new Date());
		comment.setDish(dish);
		
		commentService.save(comment);
		
		return "redirect:/comments?dishId=" + dish.getId();
	}
}
