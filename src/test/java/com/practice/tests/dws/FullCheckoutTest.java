package com.practice.tests.dws;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.practice.pages.ap.BaseTest;
import com.practice.pages.dws.*;

public class FullCheckoutTest extends BaseTest {

	@Test
	public void testCompleteCheckout() {
		ProductsPage product = new ProductsPage(driver);
		product.clickAddtoCartButton();
		product.clickCartLink();

		CartPage cart = new CartPage(driver);
		cart.acceptTerms();
		cart.clickCheckoutButton();

		HomePage home = new HomePage(driver);
		home.clickLink();

		LoginPage login = new LoginPage(driver);
		login.enterLoginCredentials("rosemary@testmail.com", "rosemary");
		login.clickLogin();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement accountInfo = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".info-account")));
		Assert.assertTrue(accountInfo.isDisplayed());
		cart.acceptTerms();
		cart.clickCheckoutButton();

		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.completeBillingAddress();
		checkout.completeShippingAddress();
		checkout.completeShippingMethod();
		checkout.completePaymentMethod();
		checkout.completePaymentInfoMethod();
		checkout.confirmOrderMethod();
		String orderSuccessMessage = checkout.getOrderSuccess();
		Assert.assertEquals(orderSuccessMessage.contains("Your order has been successfully processed!"),
				"Order not completed");

	}

}
