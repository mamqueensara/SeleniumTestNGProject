package com.practice.tests.dws;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.base.DemoWebshopBaseTest;
import com.practice.pages.dws.HomePage;
import com.practice.pages.dws.LoginPage;

public class LoginPageTest extends DemoWebshopBaseTest {

	@BeforeMethod
	public void launchSite() {
		openURL("demowebshop.url");
	}

	@Test(groups = "smoke")
	public void testLogin() {
		HomePage home = new HomePage(driver);
		home.clickLink();
		LoginPage login = new LoginPage(driver);
		login.enterLoginCredentials("rosemary@testmail.com", "rosemary");
		login.clickLogin();

	}

}
