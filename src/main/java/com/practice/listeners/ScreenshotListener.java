package com.practice.listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.practice.utilities.DriverManager;
import com.practice.utilities.ScreenshotUtils;


public class ScreenshotListener implements ITestListener {

	// Instead of writing screenshot logic inside every test or inside @AfterMethod.
	// To automatically capture screenshots only when a test fails
	// TestNG calls onTestFailure() whenever a test fails.
	@Override
	public void onTestFailure(ITestResult result) {
		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			String testName = result.getName();
			String path = ScreenshotUtils.takeScreenShot(driver, testName);
			System.out.println("Screenshot captured for failed test: " + path);
		}
	}

}
