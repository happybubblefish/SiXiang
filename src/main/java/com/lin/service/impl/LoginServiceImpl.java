package com.lin.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lin.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

	public String findLoggedInUsername() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		return auth.getName();
	}

	public void autologin(String username, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);

		Authentication request = new UsernamePasswordAuthenticationToken(userDetails, password);
		Authentication result = authenticationManager.authenticate(request);

		SecurityContextHolder.getContext().setAuthentication(result);
		System.out.printf("Auto login successfully", username);
		logger.debug(String.format("Auto login %s successfully!", username));
	}

}
