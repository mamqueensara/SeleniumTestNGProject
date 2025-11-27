package com.practice.pages.dws;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	private WebElement email;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Log in']")
	private WebElement loginButton;

	public void enterLoginCredentials(String username, String passwrd) {
		email.sendKeys(username);
		password.sendKeys(passwrd);

	}

	public void clickLogin() {
		loginButton.click();
	}

}
