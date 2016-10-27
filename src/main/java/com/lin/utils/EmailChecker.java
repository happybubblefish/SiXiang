package com.lin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailChecker {
	
	private static Pattern pattern;
	private static Matcher matcher;

	private static final String EMAIL_PATTERN =
		"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public static boolean validate(final String input) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(input);
		return matcher.matches();
	}
}
