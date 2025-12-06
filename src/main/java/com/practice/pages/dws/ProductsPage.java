package com.practice.pages.dws;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage {

	WebDriver driver;

	public ProductsPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input.button-2.product-box-add-to-cart-button")
	private List<WebElement> addToCartButtons;

	@FindBy(css = "a[href='/cart'][2]")
	private WebElement cartLink;

	public void clickAddtoCartButton() {// Normal click fails when something overlaps the element thats we use js click

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfAllElements(addToCartButtons));
		WebElement cartButton = addToCartButtons.get(1);// click first visible button
		// Scroll to center
		// ScrollIntoView is a javascript function that tells
		// the browser to Bring the element to the center of the viewport, not just the top.
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", cartButton);
		// Perform a JavaScript click on the first parameter we passed, that is button
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartButton);
		// wait for the cart popup to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bar-notification")));

	}

	public void clickCartLink() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/cart']"))).click();

	}

}
