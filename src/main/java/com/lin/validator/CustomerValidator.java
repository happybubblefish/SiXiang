package com.lin.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lin.model.Customer;
import com.lin.utils.PhoneChecker;

@Component("customerValidator")
public class CustomerValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Customer.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Customer customer = (Customer)target;
		
		if(customer.getFirstName().equals("")){
			errors.rejectValue("firstName", "Customer.empty.firstname");
		}
		
		if(customer.getLastName().equals("")){
			errors.rejectValue("lastName", "Customer.empty.lastname");
		}
		
		if(customer.getPhone().equals("")){
			errors.rejectValue("phone", "Customer.empty.phone");
		}else if(!PhoneChecker.validate(customer.getPhone())){
			errors.rejectValue("phone", "Customer.invalid.phone");
		}
		
		if(customer.getAddress().equals("")){
			errors.rejectValue("address", "Customer.empty.address");
		}
	}
}
