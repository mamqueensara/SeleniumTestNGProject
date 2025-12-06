package com.practice.utilities;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties props = new Properties();// Properties is specifically made for reading
	// configuration files like config.properties.A built-in Java class for storing
	// key-value pairs.
	// Loads the given config file

	public static void load(String fileName) {
		try (InputStream input = ConfigReader.class.getResourceAsStream("/" + fileName)) {
			if (input == null) {
				throw new RuntimeException("Config file not found: " + fileName);
			}
			props = new Properties(); // reset before loading
			props.load(input);// loads all key-value pairs from your config.properties file into that
								// container.

		} catch (Exception e) {
			throw new RuntimeException("Cannot load config.properties file", e);

		}
	}

	public static String get(String key) {
		return props.getProperty(key);
	}

}
