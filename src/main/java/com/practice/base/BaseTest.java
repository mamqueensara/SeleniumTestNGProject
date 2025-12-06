package com.practice.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.practice.utilities.ConfigReader;
import com.practice.utilities.DriverManager;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = DriverManager.getDriver();
	}

	public void openURL(String urlKey) {
		driver.get(ConfigReader.get(urlKey));// reads URL from config.properties
	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}

}
