package com.practice.pages.ap;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountStartPage {

	private WebDriver driver;

	public CreateAccountStartPage(WebDriver driver) {
		this.driver = driver;
	}

//Locators 
	private By emailField = By.id("email_create");
	private By submitCreateButton = By.id("SubmitCreate");
	private By invalidEmailErrMessage = By.xpath("//div[@id='create_account_error']");
	private By alreadyExistingErrMessage = By.xpath("//div[@id='create_account_error']//li");

	// Invalid email address

	// Actions
	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void clicksubmitCreateButton() {
		driver.findElement(submitCreateButton).click();
	}

	public String getinvalidEmailErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(invalidEmailErrMessage));
		return errMessage.getText();
	}

	public String getalreadyExistingErrMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement errMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(alreadyExistingErrMessage));
		return errMessage.getText();
	}

}
