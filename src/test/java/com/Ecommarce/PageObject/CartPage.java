package com.Ecommarce.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(linkText = "Proceed To Checkout")
    WebElement proceedToCheckoutBtn;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void goToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutBtn))
            .click();
    }
}
