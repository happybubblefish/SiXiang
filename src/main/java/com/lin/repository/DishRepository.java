package com.lin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

}
