package com.lin.service;

import com.lin.model.UserCredentials;

public interface UserCredentialsService {
	UserCredentials findByUsername(String username);
	UserCredentials save(UserCredentials user);
}
