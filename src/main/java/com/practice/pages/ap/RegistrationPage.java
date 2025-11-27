package com.practice.pages.ap;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

	private WebDriver driver;

	public RegistrationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);// Initialize PageFactory
	}

	// Locators using FindBy
	@FindBy(xpath = " //div[@class='alert alert-danger']")
	private WebElement errMessage;

	@FindBy(id = "id_gender1")
	private WebElement titleMr;

	@FindBy(id = "id_gender2")
	private WebElement titleMrs;

	@FindBy(id = "customer_firstname")
	private WebElement firstName;

	@FindBy(id = "customer_lastname")
	private WebElement lastName;

	@FindBy(id = "passwd")
	private WebElement passWord;

	@FindBy(id = "days")
	private WebElement days;

	@FindBy(id = "months")
	private WebElement months;

	@FindBy(id = "years")
	private WebElement years;

	@FindBy(id = "newsletter")
	private WebElement newsletterCheckbox;

	@FindBy(id = "optin")
	private WebElement specialoffersCheckbox;

	@FindBy(id = "submitAccount")
	private WebElement submitButton;

	public void clickRadioButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(titleMr));
		titleMr.click();
	}

	public String getErrMessage() {
		return errMessage.getText();

	}

	public void fillPersonalInformation(String fname, String lname, String password) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		passWord.sendKeys(password);

	}

	public void selectDOB() {
		new Select(days).selectByValue("24");
		new Select(months).selectByValue("5");
		new Select(years).selectByValue("1991");

	}

	public void checkNewsLetterAndOffers(Boolean newsletter, Boolean specialoffers) {
		if (newsletter && !newsletterCheckbox.isSelected()) // if it is NOT selected → click
															// if it is already selected → do nothing
			newsletterCheckbox.click();

		if (specialoffers && !specialoffersCheckbox.isSelected())
			specialoffersCheckbox.click();

	}

	public void clickSubmitButton() {
		submitButton.click();

	}

}
