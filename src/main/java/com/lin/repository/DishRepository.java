package com.lin.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lin.model.Dish;

@Repository
public interface DishRepository extends JpaRepository<Dish, Long> {

}
