package com.lin.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lin.model.Customer;
import com.lin.model.UserCartCombo;

@Component("userCartComboValidator")
public class UserCartComboValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return UserCartCombo.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserCartCombo userCartCombo = (UserCartCombo)target;
		
//		if(userCartCombo.getFirstName().equals("")){
//			errors.rejectValue("firstName", "ShoppingCart.empty.firstName");
//		}
		
	}

}
