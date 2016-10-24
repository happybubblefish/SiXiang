package com.lin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.UserCredentials;
import com.lin.repository.UserCredentialsRepository;
import com.lin.service.UserCredentialsService;

@Service
@Transactional
public class UserCredentialsServiceImpl implements UserCredentialsService {
	
	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	@Override
	public UserCredentials findByUsername(String username) {
		return userCredentialsRepository.findByUsername(username);
	}

	@Override
	public UserCredentials save(UserCredentials user) {
		return userCredentialsRepository.save(user);
	}
}
