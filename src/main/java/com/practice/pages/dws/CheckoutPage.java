package com.practice.pages.dws;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@onclick='Billing.save()']")
	private WebElement billingContinueBtn;

	@FindBy(xpath = "//input[@onclick='Shipping.save()']")
	private WebElement shippingAddrContinueBtn;

	@FindBy(xpath = "//input[@class='button-1 shipping-method-next-step-button']")
	private WebElement shippingMethodContinueBtn;

	@FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button']")
	private WebElement paymentMethodContinueBtn;

	@FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button']")
	private WebElement paymentInfoContinueBtn;

	@FindBy(xpath = "//input[@value='Confirm']")
	private WebElement confirmOrderButton;

	@FindBy(css = "div[class='title'] strong")
	private WebElement orderSuccessMessage;

	public void completeBillingAddress() {
		billingContinueBtn.click();
	}

	public void completeShippingAddress() {
		shippingAddrContinueBtn.click();
	}

	public void completeShippingMethod() {
		shippingMethodContinueBtn.click();
	}

	public void completePaymentMethod() {
		paymentMethodContinueBtn.click();
	}

	public void completePaymentInfoMethod() {
		paymentInfoContinueBtn.click();
	}

	public void confirmOrderMethod() {
		confirmOrderButton.click();
	}

	public String getOrderSuccess() {
		return orderSuccessMessage.getText();

	}

}
