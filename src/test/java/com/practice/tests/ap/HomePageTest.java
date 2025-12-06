package com.practice.tests.ap;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.base.AutomationBaseTest;

public class HomePageTest extends AutomationBaseTest {

	@BeforeMethod
	public void launchSite() throws InterruptedException {
		openURL("automationpractice.url");

	}

	@Test
	public void verifyHomePageTitle() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "MyShop";
		Assert.assertEquals(actualTitle, expectedTitle, "Homepage title is wrong");

	}

}
