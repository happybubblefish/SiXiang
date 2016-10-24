package com.lin.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lin.model.UserCredentials;
import com.lin.service.UserCredentialsService;

@Component
public class UserCredentialsValidator implements Validator {
	
	@Autowired
	private UserCredentialsService userCredentialsService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserCredentials.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCredentials userCredentials = (UserCredentials)target;
		
		if(userCredentialsService.findByUsername(userCredentials.getUsername()) != null){
			errors.rejectValue("username", "Registration.duplicated.username");
		}
		
		if(!userCredentials.getPassword().equals(userCredentials.getPasswordConfirm())){
			errors.rejectValue("password", "Registration.diff.password");
		}
		
	}

}
