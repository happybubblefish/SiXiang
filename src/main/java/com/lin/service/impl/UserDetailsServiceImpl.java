package com.lin.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.lin.model.Authority;
import com.lin.model.UserCredentials;
import com.lin.repository.UserCredentialsRepository;

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserCredentialsRepository userCredentialsRepository;

	@Transactional(readOnly = true)
	public User loadUserByUsername(String username) throws UsernameNotFoundException {

		// List<UserCredentials> userCredentialsList =
		// userCredentialsRepository.findByUsername(username);
		//
		// if (userCredentialsList.size() == 0) {
		// return null;
		// }

		UserCredentials user = userCredentialsRepository.findByUsername(username);

		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

		for (Authority au : user.getAuthorities()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(au.getName()));
		}

		return new User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}
}
