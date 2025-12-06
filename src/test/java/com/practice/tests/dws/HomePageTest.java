package com.practice.tests.dws;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.base.DemoWebshopBaseTest;
import com.practice.pages.dws.*;

public class HomePageTest extends DemoWebshopBaseTest {

	@BeforeMethod
	public void launchSite() {
		openURL("demowebshop.url");
	}

	@Test
	public void testHomePage() {
		HomePage home = new HomePage(driver);
		home.clickLink();

	}

}
