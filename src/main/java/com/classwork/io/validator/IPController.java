package com.classwork.io.validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import static com.classwork.threads.io.Messages.*;

public class IPController {

	private static Stream<String> streamBlackList;
	private static final String filename = "blacklist.txt";
	private static final Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
	private static final String IP_REGEX = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
	private static final Pattern pattern = Pattern.compile(IP_REGEX);
	
	private static Stream<String> checkLastModified(String fileName) {
		try {
			BasicFileAttributes attribute = Files.readAttributes(Paths.get(fileName), BasicFileAttributes.class);
			if (!attribute.creationTime().equals(attribute.lastModifiedTime())) {
				streamBlackList = Files.lines(Paths.get(fileName));
			}
		} catch (IOException e) {
			LOGGER.log(Level.SEVERE, "Error: ", e);
		}
		return streamBlackList;
	}

	private static boolean isInBlackList(String ipAddress) {
		return checkLastModified(filename).anyMatch(line -> line.equals(ipAddress));
	}

	public static String checkIpAddress(String ipAddress) {
		return pattern.matcher(ipAddress).find() ? isInBlackList(ipAddress) ? DISALLOW : ALLOW : INVALID;
	}

	public static void run() {
		System.out.println(MESSAGE);
		try (Scanner sc = new Scanner(System.in)) {
			while (sc.hasNext()) {
				String line = sc.next();
				if (!"0".equals(line)) {
//					LOGGER.info(checkIpAddress(line));
					System.out.println(checkIpAddress(line));
				} else {
					break;
				}
				LOGGER.info(MESSAGE);
			}
		}
	}
}
