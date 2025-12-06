package com.practice.tests.ap;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.base.AutomationBaseTest;
import com.practice.pages.ap.ForgotPasswordPage;
import com.practice.pages.ap.HomePage;
import com.practice.pages.ap.LoginPage;

public class LoginPageTest extends AutomationBaseTest {

	@BeforeMethod
	public void launchSite() {
		openURL("automationpractice.url");
	}

	@Test
	public void testInvalidLogin() {

		HomePage home = new HomePage(driver);
		home.signIN();
		LoginPage login = new LoginPage(driver);
		login.enterEmail("invalid@email.com");
		login.enterPassword("wrongpass");
		login.clickSignInBtn();
		System.out.println(driver.getTitle()); // Login - My Shop
		String errMessage = login.getErrorMessage();
		Assert.assertTrue(errMessage.contains("Authentication failed"));
	}

	@Test
	public void testValidLogin() {
		HomePage home = new HomePage(driver);
		home.signIN();

		LoginPage login = new LoginPage(driver);
		login.enterEmail("rose@testmail.com");
		login.enterPassword("rosemary");
		login.clickSignInBtn();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement accountInfo = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".info-account")));
		Assert.assertTrue(accountInfo.isDisplayed());
		String expectedTitle = "My account - My Shop";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Login failed!");
		System.out.println("Loginsuccessful.Current page title is " + driver.getTitle());

	}

	@Test
	public void verifyForgotPasswordNavigation() {
		HomePage home = new HomePage(driver);
		home.signIN();
		LoginPage login = new LoginPage(driver);
		login.forgotPassword();
		String expectedTitle = "Forgot your password - My Shop";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Forgot password link is not navigating correctly!");

	}

	@Test
	public void verifyForgotPasswordWithValidEmail() {

		HomePage home = new HomePage(driver);
		home.signIN();
		LoginPage login = new LoginPage(driver);
		login.forgotPassword();
		ForgotPasswordPage forgotpage = new ForgotPasswordPage(driver);
		forgotpage.enterEmail("rose@testmail.com");
		forgotpage.retrievepasswdButtonClick();
		String errMessage = forgotpage.getSuccessMessage();
		Assert.assertTrue(errMessage.contains("A confirmation email has been sent to your address"),
				"Expected success message not displayed!");
	}

	@Test
	public void verifyForgotPasswordWithInValidEmail() {

		HomePage home = new HomePage(driver);
		home.signIN();
		LoginPage login = new LoginPage(driver);
		login.forgotPassword();
		ForgotPasswordPage forgotpage = new ForgotPasswordPage(driver);
		forgotpage.enterEmail("123@testmail.com");
		forgotpage.retrievepasswdButtonClick();
		String errMessage = forgotpage.getFailMessage();
		Assert.assertTrue(errMessage.contains("There is no account registered for this email address."),
				"Expected failure message not displayed!");
	}

}
