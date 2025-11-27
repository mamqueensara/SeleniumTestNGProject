package com.practice.tests.ap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.pages.ap.BaseTest;

public class HomePageTest extends BaseTest {

	@BeforeMethod
	public void launchSite() {
		openURL("automationpractice.url");
	}

	@Test
	public void verifyHomePageTitle() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "My Shop";
		Assert.assertEquals(actualTitle, expectedTitle, "Homepage title is wrong");

	}

}
