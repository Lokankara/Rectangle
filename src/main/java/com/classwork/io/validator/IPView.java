package com.classwork.io.validator;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class IPView {

	static public void setup() {

		Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

		LOGGER.setLevel(Level.INFO);

		try {
			FileHandler handler = new FileHandler("console.log");
			handler.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(handler);
		} catch (SecurityException | IOException e) {
			LOGGER.log(Level.SEVERE, "Can`t find the file name, ", e);
		} finally {
			LOGGER.log(Level.INFO, "Logging configuration complete");
		}
	}
}
