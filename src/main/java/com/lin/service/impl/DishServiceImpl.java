package com.lin.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lin.model.Dish;
import com.lin.repository.DishRepository;
import com.lin.service.DishService;

@Service
@Transactional
public class DishServiceImpl implements DishService {

	@Autowired
	private DishRepository dishRepository;
	
	public List<Dish> findAllDishes() {
		return dishRepository.findAll();
	}

	public List<Dish> findAllDeals() {
		List<Dish> allDishes = findAllDishes();
		List<Dish> dishes = allDishes.stream().filter(d -> d.getDiscount() < 1.0).collect(Collectors.toList());
		
		return dishes;
	}

	
	public List<Dish> findAllChefRmd() {
		List<Dish> allDishes = findAllDishes();
		List<Dish> chefRmdDishes = allDishes.stream().filter(d -> d.isChefRmd() == true).collect(Collectors.toList());
		
		return chefRmdDishes;
	}

	
	public List<Dish> findFirstNDishes(int limit) {
		List<Dish> allDishes = dishRepository.findAll();
		List<Dish> dishes = allDishes.stream().limit(limit).collect(Collectors.toList());
		
		return dishes;
	}

	public List<Dish> findOneKindOfDishes(String dishName) {
		List<Dish> allDishes = dishRepository.findAll();
		List<Dish> dishes = allDishes.stream().filter(d -> d.getKind().getName().equalsIgnoreCase(dishName)).collect(Collectors.toList());
		
		return dishes;
	}

	@Override
	public Dish findOne(Long dishId) {
		return dishRepository.findOne(dishId);
	}	
}
