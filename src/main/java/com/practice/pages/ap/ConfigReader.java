package com.practice.pages.ap;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static Properties props = new Properties();// Properties is specifically made for reading
	// configuration files like config.properties.A built-in Java class for storing
	// key-value pairs.
	static {
		try (InputStream input = ConfigReader.class.getResourceAsStream("/config.properties")) {
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
