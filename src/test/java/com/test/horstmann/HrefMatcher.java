package com.test.horstmann;

import java.io.*;
import java.net.*;
import java.nio.charset.*;
import java.util.regex.*;

public class HrefMatcher {

	public static void main(String[] args) {
		try {
			// get URL string from command line or use default
			String urlString;
			if (args.length > 0)
				urlString = args[0];
			else
				urlString = "https://www.gutenberg.org/cache/epub/28885/pg28885-images.html.utf8";
//			urlString = "https://www.gutenberg.org/cache/epub/28885/pg28885.txt";

			// read contents of URL
			InputStream in = new URL(urlString).openStream();
			var input = new String(in.readAllBytes(), StandardCharsets.UTF_8);

			// search for all occurrences of pattern
			var patternString = "<a\\s+href\\s*=\\s*(\"[^\"]*\"|[^\\s>]*)\\s*>";
			Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
			pattern.matcher(input).results().map(MatchResult::group).forEach(System.out::println);
		} catch (IOException | PatternSyntaxException e) {
			e.printStackTrace();
		}
	}
}
