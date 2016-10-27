package com.lin.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneChecker {
	private static Pattern pattern;
	private static Matcher matcher;

	private static final String PHONE_PATTERN =	"[(][0-9]{3}[)][-][0-9]{3}[-][0-9]{4}";

	public static boolean validate(final String input) {
		pattern = Pattern.compile(PHONE_PATTERN);
		matcher = pattern.matcher(input);
		return matcher.matches();
	}
}
