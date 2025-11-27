package com.practice.tests.ap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.pages.ap.BaseTest;
import com.practice.pages.ap.CreateAccountStartPage;
import com.practice.pages.ap.HomePage;

public class AccountCreationTest extends BaseTest {

	@BeforeMethod
	public void launchSite() {
		openURL("automationpractice.url");
	}

	@Test
	public void testCreateAccountStartPage() {

		HomePage homePage = new HomePage(driver);
		homePage.signIN();
		CreateAccountStartPage startPage = new CreateAccountStartPage(driver);
		startPage.enterEmail("payal@testmail.com");
		startPage.clicksubmitCreateButton();
	}

	@Test
	public void verifyAccountWithInvalidEmail() {
		HomePage homePage = new HomePage(driver);
		homePage.signIN();
		CreateAccountStartPage startPage = new CreateAccountStartPage(driver);
		startPage.enterEmail("123testmail.com");
		startPage.clicksubmitCreateButton();
		String errorMessage = startPage.getinvalidEmailErrorMessage();
		Assert.assertTrue(errorMessage.contains("Invalid email address"), "Expected error message is not displayed");

	}

	@Test
	public void verifyAlreadyExistingAccountRegistration() {
		HomePage homePage = new HomePage(driver);
		homePage.signIN();
		CreateAccountStartPage startPage = new CreateAccountStartPage(driver);
		startPage.enterEmail("rose@testmail.com");
		startPage.clicksubmitCreateButton();
		String errorMessage = startPage.getalreadyExistingErrMessage();
		System.out.println(errorMessage);
		Assert.assertTrue(errorMessage.contains(
				"An account using this email address has already been registered. Please enter a valid password or request a new one."),
				"Expected error message is not displayed");

	}

}
