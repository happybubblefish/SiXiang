package com.lin.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.lin.model.Opinion;
import com.lin.utils.EmailChecker;

@Component("opinionValidator")
public class OpinionValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Opinion.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Opinion opinion = (Opinion)target;
		
		if(opinion.getName().equals("")){
			errors.rejectValue("name", "Opinion.empty.name");
		}
		
		if(opinion.getEmail().equals("")){
			errors.rejectValue("email", "Opinion.empty.email");
		} else if(!EmailChecker.validate(opinion.getEmail())){
			errors.rejectValue("email", "Opinion.invalid.email");
		}
		
		if(opinion.getContent().equals("")){
			errors.rejectValue("content", "Opinion.empty.content");
		}
	}
}
