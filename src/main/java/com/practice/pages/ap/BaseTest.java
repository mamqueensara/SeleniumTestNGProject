package com.practice.pages.ap;

import java.time.Duration;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

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

	public void acceptAlertIfPresent() {
		try {
			new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();

		} catch (NoAlertPresentException e) {

		}
	}

}
