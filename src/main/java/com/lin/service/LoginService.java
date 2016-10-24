package com.lin.service;

public interface LoginService {
	
	String findLoggedInUsername();

    void autologin(String username, String password);
}
