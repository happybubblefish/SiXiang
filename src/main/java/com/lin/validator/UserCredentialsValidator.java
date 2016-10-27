package com.lin.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lin.model.UserCredentials;
import com.lin.service.UserCredentialsService;
import com.lin.utils.EmailChecker;
import com.lin.utils.PasswordChecker;

@Component("userCredentialsValidator")
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
		
		if(userCredentials.getUsername().equals("")){
			errors.rejectValue("username", "Registration.empty.username");
		}else if(!EmailChecker.validate(userCredentials.getUsername())){
			errors.rejectValue("username", "Registration.invalid.username");
		}else if(userCredentialsService.findByUsername(userCredentials.getUsername()) != null){
			errors.rejectValue("username", "Registration.duplicated.username");
		}
		
		if(userCredentials.getPassword().equals("")){
			errors.rejectValue("password", "Registration.empty.password");
		}else if(!PasswordChecker.validate(userCredentials.getPassword())){
			errors.rejectValue("password", "Registration.invalid.password");
		}else if(!userCredentials.getPassword().equals(userCredentials.getPasswordConfirm())){
			errors.rejectValue("password", "Registration.diff.password");
		}
	}
}
