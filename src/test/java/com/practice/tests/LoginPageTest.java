package com.practice.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.practice.utils.BaseTest;
import com.practice.utils.ForgotPasswordPage;
import com.practice.utils.HomePage;
import com.practice.utils.LoginPage;

public class LoginPageTest extends BaseTest {

	@Test
	public void testInvalidLogin() throws InterruptedException {

		HomePage homepg = new HomePage(driver);
		homepg.signIN();

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
		HomePage homepg = new HomePage(driver);
		homepg.signIN();

		LoginPage login = new LoginPage(driver);
		login.enterEmail("rose@testmail.com");
		login.enterPassword("rosemary");
		login.clickSignInBtn();
		acceptAlertIfPresent(driver);
		String expectedTitle = "My account - My Shop";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Login failed!");
		System.out.println("Login  successful.Current page title is " + driver.getTitle());

	}

	@Test
	public void verifyForgotPasswordNavigation() {
		HomePage homepg = new HomePage(driver);
		homepg.signIN();
		LoginPage login = new LoginPage(driver);
		login.forgotPassword();
		String expectedTitle = "Forgot your password - My Shop";
		Assert.assertEquals(driver.getTitle(), expectedTitle, "Forgot password link is not navigating correctly!");

	}

	@Test 
	public void verifyForgotPasswordWithValidEmail() {

		HomePage homepg = new HomePage(driver);
		homepg.signIN();
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

		HomePage homepg = new HomePage(driver);
		homepg.signIN();
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
