package com.practice.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.utils.BaseTest;

public class HomePageTest extends BaseTest {
	
	@Test
	public void verifyHomePageTitle() {
		String actualTitle= driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle="My Shop";
		Assert.assertEquals(actualTitle,expectedTitle,"Homepage title is wrong");

	}
	
}
