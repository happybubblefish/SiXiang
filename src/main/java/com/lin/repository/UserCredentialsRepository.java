package com.lin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lin.model.UserCredentials;

@Repository("userCredentialsRepository")
public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Long> {
	
	UserCredentials findByUsername(String username);
}
