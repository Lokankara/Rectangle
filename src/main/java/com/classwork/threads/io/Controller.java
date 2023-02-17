package com.classwork.threads.io;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.classwork.threads.io.Messages.*;

class Controller implements Serializable {

	private static final long serialVersionUID = 29136421241571165L;
	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String IP_PATTERN = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";

	private Controller() {
	}

	static void start() {
		final String filename = "blacklist.txt";
		Map<String, Long> whitelist = Collections.synchronizedMap(new LinkedHashMap<>());
		Set<String> blacklist = getSet(filename);
		whitelist = getMap("whitelist.txt");
		compare(whitelist, blacklist);

	}

	private static void compare(Map<String, Long> whitelist, Set<String> blacklist) {

//		for (String key: whitelist.keySet()){
		for (String key : blacklist) {
			whitelist.compute(key, (k, v) -> v == null ? 1 : ++v);
//			if(blacklist.contains(key)) {
//			} else {
//				whi
//			}
		}

//		boolean containsAll = whitelist.keySet().containsAll(blacklist);
		print(whitelist);
	}

	static Set<String> getSet(String filename) {
		Set<String> blacklist = Collections.synchronizedSet(new HashSet<>());
		try (Scanner scanner = new Scanner(new File(filename))) {
			Matcher matcher;
			while (scanner.hasNext()) {
				matcher = Pattern.compile(IP_PATTERN).matcher(scanner.next());
				if (matcher.find()) {
					blacklist.add(matcher.group());
				}
			}
			print(blacklist);
		} catch (IOException e) {
			System.err.printf("%s%n", e.getMessage());
		}
		return blacklist;
	}

	static Map<String, Long> getMap(String filename) {
		Map<String, Long> linkedMap = Collections.synchronizedMap(new LinkedHashMap<>());
		try (Scanner scanner = new Scanner(new File(filename))) {
			Matcher matcher;
			while (scanner.hasNext()) {

				matcher = Pattern.compile(IP_PATTERN).matcher(scanner.next());
				if (matcher.find()) {
					linkedMap.compute(matcher.group(), (key, value) -> value == null ? 1 : ++value);
				}
			}
			print(linkedMap);
		} catch (IOException e) {
			System.err.printf("%s%n", e.getMessage());
		}
		return linkedMap;
	}

	static void print(Set<String> set) {
		System.out.println("BlackList:");
		set.forEach(System.out::println);
	}

	static void print(Map<String, Long> map) {
		System.out.println("WhiteList:");
		map.entrySet().forEach(System.err::println);
	}
}
