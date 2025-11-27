package com.practice.pages.dws;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;

	public CartPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "termsofservice")
	private WebElement termsCheckbox;

	@FindBy(id = "checkout")
	private WebElement checkoutButton;

	public void acceptTerms() {
		if (!termsCheckbox.isSelected())
			termsCheckbox.click();
	}

	public void clickCheckoutButton() {
		checkoutButton.click();
	}

}
