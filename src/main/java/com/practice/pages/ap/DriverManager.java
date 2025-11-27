package com.practice.pages.ap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {// DriverManager is a helper class
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();// EACH thread gets its own browser → no sharing,
																		// no conflicts
	// Each thread stores its own WebDriver safely.gives each test (thread) its own
	// browser

	public static WebDriver getDriver() {// Creates & returns a browser instance
		if (driver.get() == null) {// if the driver is already created.If not, it creates a new browser instance.
			WebDriverManager.chromedriver().setup();// Automatically downloads and configures
													// ChromeDriver.--Automatically handles driver

			WebDriver newDriver = new ChromeDriver();// Launches a new Chrome browser.--Opens Chrome
			newDriver.manage().window().maximize();
			driver.set(newDriver);

		}
		return driver.get();
	}

	public static void quitDriver() {
		if (driver.get() != null) {
			driver.get().quit();// Closes the browser and resets the driver
			driver.remove();
		}
	}

}
