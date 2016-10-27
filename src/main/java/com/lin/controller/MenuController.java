package com.lin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lin.model.Dish;
import com.lin.service.DishService;

@Controller
public class MenuController {

	@Autowired
	private DishService dishService;

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
}
