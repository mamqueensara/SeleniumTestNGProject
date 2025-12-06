package com.practice.pages.ap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	 WebDriver driver;
	// Locator
	private By signIn = By.className("login");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}//Passing WebDriver to each page object is like giving each page its own remote control to use the same browser.

	// Action
	// Sign in option in homepage navigates to account login
	public void signIN() {
		driver.findElement(signIn).click();
	}

}
