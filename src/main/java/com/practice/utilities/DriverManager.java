package com.practice.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
			ChromeOptions options = new ChromeOptions();
			// Read incognito value from the active config file
			String incognito = ConfigReader.get("incognito");
			if ("true".equalsIgnoreCase(incognito)) {
				options.addArguments("--incognito");
			}
			options.addArguments("--disable-features=PasswordManager,PasswordLeakDetection");
			options.addArguments("--ignore-certificate-errors");
			options.addArguments("--allow-insecure-localhost");
			options.addArguments("--disable-web-security");
			options.addArguments("--allow-running-insecure-content");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-site-isolation-trials");
			options.addArguments("--disable-features=IsolateOrigins,site-per-process");
			options.addArguments("--disable-features=BlockInsecurePrivateNetworkRequests");
			options.addArguments("--unsafely-treat-insecure-origin-as-secure=http://automationpractice.pl");
			options.setAcceptInsecureCerts(true);
			WebDriver newDriver = new ChromeDriver(options);// Launches a new Chrome browser.--Opens Chrome
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
