package com.practice.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = DriverManager.getDriver();
		driver.get(ConfigReader.get("base.url"));

	}

	@AfterMethod
	public void tearDown() {
		DriverManager.quitDriver();
	}

	public void acceptAlertIfPresent(WebDriver driver) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {

		}
	}

}
