package com.practice.pages.dws;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	WebDriverWait wait;

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	public void acceptTerms() {

		// Wait for any AJAX loader to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ajax-loading-block-window")));

		// Always re-locate checkbox freshly to avoid StaleElementReferenceException
		WebElement terms = wait.until(ExpectedConditions.elementToBeClickable(By.id("termsofservice")));

		if (!terms.isSelected()) {
			terms.click();
		}
	}

	public void clickCheckoutButton() {
		WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
		checkout.click();
	}

}
