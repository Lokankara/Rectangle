package com.test.horstmann.io;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExpTest {

	public RegExpTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String quote = "aba*abaa**aabaa***";
		String[] words = quote.split("a\\*+", 10);
		for (String word : words) {
			System.out.println(word);
		}

		String str1 = "xxzz";
		String str2 = "xyz";
		String str3 = "yzz";
		Pattern patternq = Pattern.compile("(xx)*y?z{1,}");
		Matcher matcherq = patternq.matcher(str1);
		System.out.println(matcherq.matches());
		System.out.println(patternq.matcher(str2).matches());
		System.out.println(Pattern.compile("(xx)*y?z{1,}").matcher(str3).matches());

		String str = "OCPJP 2013 OCPJP7";
		Pattern pattern = Pattern.compile("\\b\\w+\\D\\b");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			System.out.println(matcher.group());
		}
		String strs = "Suneetha N.=9876543210, Pratish Patil=9898989898";
		Pattern patternd = Pattern.compile("(\\w+)(\\s\\.+)(=)(\\d{10})");
		Matcher matcherd = patternd.matcher(strs);
		if(matcherd.find()) {
			System.out.println(matcherd.group());			
		}
		String newStr = matcherd.replaceAll("$4:$2,$1");
		System.out.println(newStr);

		String date = "10-01-2012"; // 10th January 2012 in dd-mm-yyyy format
		String[] dateParts = date.split("-");
		System.out.print("Using String.split method: ");
		for (String part : dateParts) {
			System.out.print(part + " ");
		}
		System.out.print("\nUsing regex pattern: ");
		Pattern datePattern = Pattern.compile("-");
		dateParts = datePattern.split(date);
		for (String part : dateParts) {
			System.out.print(part + " ");
		}
		
		try (Scanner consoleScanner = new Scanner(System.in)) {
			consoleScanner.close(); // CLOSE
			consoleScanner.close();
			}
		String test = "I am preparing for OCPJP";
		String[] tokens = test.split("\\s");
		System.out.println(tokens.length);
	}
}
