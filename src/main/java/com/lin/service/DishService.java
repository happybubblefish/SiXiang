package com.lin.service;

import java.util.List;

import com.lin.model.Dish;

public interface DishService {
	
	List<Dish> findAllDishes();
	
	List<Dish> findAllDeals();
	
	List<Dish> findAllChefRmd();
	
	List<Dish> findFirstNDishes(int limit);
	
	List<Dish> findOneKindOfDishes(String dishName);
}
