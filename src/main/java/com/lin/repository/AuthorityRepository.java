package com.lin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.model.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
	List<Authority> findByName(String name);
}
