package com.example.tareaAPIfullStack.validators;

import java.util.regex.Pattern;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class PrefixValidator implements ConstraintValidator<ValidEmployeeCode, String>{
	
	//Patrón = EMP-dep-1234

	private static final Pattern CODE_PATTERN = Pattern.compile("^EMP-[a-z]{3}-\\d{4}$");

	public void initialize(ValidEmployeeCode constraintAnnotation) {
	}

	public boolean isValid(String code, ConstraintValidatorContext context) {
		if (code == null) {
			return false;
		}
		return CODE_PATTERN.matcher(code).matches();
	}	
}
