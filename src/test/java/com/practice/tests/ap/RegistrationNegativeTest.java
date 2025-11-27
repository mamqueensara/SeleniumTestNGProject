package com.practice.tests.ap;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.pages.ap.BaseTest;
import com.practice.pages.ap.CreateAccountStartPage;
import com.practice.pages.ap.HomePage;
import com.practice.pages.ap.RegistrationPage;

public class RegistrationNegativeTest extends BaseTest {

	@BeforeMethod
	public void launchSite() {
		openURL("automationpractice.url");
	}

	@Test
	public void testRequiredFieldEmpty() {
		HomePage homepage = new HomePage(driver);
		homepage.signIN();
		CreateAccountStartPage startpage = new CreateAccountStartPage(driver);
		startpage.enterEmail("kannan@testmail.com");
		startpage.clicksubmitCreateButton();
		// WAIT UNTIL registration page is loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.clickSubmitButton();
		String err = regPage.getErrMessage();
		Assert.assertTrue(err.contains("firstname is required"));
		Assert.assertTrue(err.contains("lastname is required"));
		Assert.assertTrue(err.contains("passwd is required"));

	}

	@Test
	public void testInvalidNames() {
		HomePage homepage = new HomePage(driver);
		homepage.signIN();
		CreateAccountStartPage startpage = new CreateAccountStartPage(driver);
		startpage.enterEmail("paul@testmail.com");
		startpage.clicksubmitCreateButton();
		// WAIT UNTIL registration page is loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.fillPersonalInformation("paul12", "peter23", "12345");
		regPage.clickSubmitButton();
		String err = regPage.getErrMessage();
		Assert.assertTrue(err.contains("firstname is invalid"));
		Assert.assertTrue(err.contains("lastname is invalid"));

	}

	@Test
	public void testWeakPassword() {
		HomePage homepage = new HomePage(driver);
		homepage.signIN();
		CreateAccountStartPage startpage = new CreateAccountStartPage(driver);
		startpage.enterEmail("saif@testmail.com");
		startpage.clicksubmitCreateButton();
		// WAIT UNTIL registration page is loaded
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer_firstname")));
		RegistrationPage regPage = new RegistrationPage(driver);
		regPage.fillPersonalInformation("saif", "shah", "123");
		regPage.clickSubmitButton();
		String err = regPage.getErrMessage();
		Assert.assertTrue(err.contains("passwd is invalid"));

	}

}
