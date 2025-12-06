package com.practice.tests.dws;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.practice.base.DemoWebshopBaseTest;
import com.practice.pages.dws.*;

public class FullCheckoutTest extends DemoWebshopBaseTest {

	@BeforeMethod
	public void launchSite() {
		openURL("demowebshop.url");
	}

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

		// WAIT for login to finish
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href='/logout']")));

		// After login, you MUST re-open cart page
		driver.get("https://demowebshop.tricentis.com/cart");

		// Create NEW CartPage object – DOM is fresh
		CartPage cartAfterLogin = new CartPage(driver);
		cartAfterLogin.acceptTerms();
		cartAfterLogin.clickCheckoutButton();

		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.completeBillingAddress();
		checkout.completeShippingAddress();
		checkout.completeShippingMethod();
		checkout.completePaymentMethod();
		checkout.completePaymentInfoMethod();
		checkout.confirmOrderMethod();
		String orderSuccessMessage = checkout.getOrderSuccess();
		System.out.println(orderSuccessMessage);
		Assert.assertTrue(orderSuccessMessage.contains("Your order has been successfully processed!"),
				"Order not completed");

	}

}
