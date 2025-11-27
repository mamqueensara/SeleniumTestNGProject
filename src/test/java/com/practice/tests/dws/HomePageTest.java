package com.practice.tests.dws;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.practice.pages.ap.BaseTest;
import com.practice.pages.dws.*;

public class HomePageTest extends BaseTest {

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
