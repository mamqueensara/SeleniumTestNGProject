package com.practice.pages.ap;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

	private WebDriver driver;

	public ForgotPasswordPage(WebDriver driver) {

		this.driver = driver;
	}

	// Locators
	private By emailField = By.id("email");
	private By retrievePasswordButton = By.xpath("//button[@class='btn btn-default button button-medium']");
	private By successMessage = By.cssSelector(".alert.alert-success");
	private By failMessage = By.cssSelector("div[class='alert alert-danger'] ol li");

	// Actions
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);

	}

	public void retrievepasswdButtonClick() {
		driver.findElement(retrievePasswordButton).click();

	}

	public String getSuccessMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement success = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
		return success.getText();

	}

	public String getFailMessage() {
		return driver.findElement(failMessage).getText();

	}

}
