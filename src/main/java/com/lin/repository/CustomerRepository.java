package com.lin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.model.Customer;
import java.lang.String;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	List<Customer> findByEmail(String email);
}
