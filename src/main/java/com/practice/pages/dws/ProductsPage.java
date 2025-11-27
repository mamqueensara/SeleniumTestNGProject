package com.practice.pages.dws;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@value='Add to cart'])[2]")
	private WebElement addToCartButton;

	@FindBy(linkText = "shopping cart")
	private WebElement cartLink;

	public void clickAddtoCartButton() {

		addToCartButton.click();
	}
	
	public void clickCartLink() {

		cartLink.click();
	}
	
}
