package com.practice.pages.dws;

import java.time.Duration;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class CheckoutPage {

     WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        js = (JavascriptExecutor) driver;
    }

    // ---------- LOCATORS ----------
    @FindBy(css = "input[onclick='Billing.save()'], button[onclick='Billing.save()']")
    private WebElement billingContinueBtn;

    @FindBy(css = "input[onclick='Shipping.save()'], button[onclick='Shipping.save()']")
    private WebElement shippingContinueBtn;

    @FindBy(css = "input[onclick='ShippingMethod.save()'], button[onclick='ShippingMethod.save()']")
    private WebElement shippingMethodContinueBtn;

    @FindBy(css = "input[onclick='PaymentMethod.save()'], button[onclick='PaymentMethod.save()']")
    private WebElement paymentMethodContinueBtn;

    @FindBy(css = "input[onclick='PaymentInfo.save()'], button[onclick='PaymentInfo.save()']")
    private WebElement paymentInfoContinueBtn;

    @FindBy(css = "input[onclick='ConfirmOrder.save()'], button[onclick='ConfirmOrder.save()']")
    private WebElement confirmOrderBtn;

    @FindBy(css = "div.title strong")
    private WebElement orderSuccessMessage;


    // ---------- REUSABLE CLICK METHOD ----------
    private void clickUsingJS(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }


    // ---------- Action Methods ----------

    public void completeBillingAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("billing-buttons-container")));
        clickUsingJS(billingContinueBtn);
    }

    public void completeShippingAddress() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("shipping-buttons-container")));
        clickUsingJS(shippingContinueBtn);
    }

    public void completeShippingMethod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("shipping-method-buttons-container")));
        clickUsingJS(shippingMethodContinueBtn);
    }

    public void completePaymentMethod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("payment-method-buttons-container")));
        clickUsingJS(paymentMethodContinueBtn);
    }

    public void completePaymentInfoMethod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("payment-info-buttons-container")));
        clickUsingJS(paymentInfoContinueBtn);
    }

    public void confirmOrderMethod() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("confirm-order-buttons-container")));
        clickUsingJS(confirmOrderBtn);
    }

    public String getOrderSuccess() {
        wait.until(ExpectedConditions.visibilityOf(orderSuccessMessage));
        return orderSuccessMessage.getText().trim();
    }
}
