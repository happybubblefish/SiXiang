package com.lin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
	private static Pattern pattern;
	private static Matcher matcher;

	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z0-9$@$!%*?&]{8,10}";

	public static boolean validate(final String input) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	
}
