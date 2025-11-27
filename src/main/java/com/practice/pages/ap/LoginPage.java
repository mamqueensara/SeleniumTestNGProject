package com.practice.pages.ap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	// Locators
	private By emailField = By.id("email");
	private By passwordField = By.id("passwd");
	private By signInButton = By.id("SubmitLogin");
	private By errorMessage =By.xpath("//div[@class='alert alert-danger']//ol");
	private By forgotPasswordLink= By.linkText("Forgot your password?");

	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	//Actions
	public void enterEmail(String emailAddress) {
		driver.findElement(emailField).sendKeys(emailAddress);
		
	}
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
		
	}
	public void clickSignInBtn() {
		driver.findElement(signInButton).click();
		
	}
	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
		
	}
	public void forgotPassword() {
		driver.findElement(forgotPasswordLink).click();
		
	}
	

}
