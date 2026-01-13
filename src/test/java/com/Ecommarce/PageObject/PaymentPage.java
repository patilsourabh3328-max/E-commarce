package com.Ecommarce.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Ecommarce.Utilities.JsUtil;

public class PaymentPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(name = "name_on_card")
    WebElement name;

    @FindBy(name = "card_number")
    WebElement card;

    @FindBy(name = "cvc")
    WebElement cvc;

    @FindBy(name = "expiry_month")
    WebElement month;

    @FindBy(name = "expiry_year")
    WebElement year;

    @FindBy(xpath = "//button[@id='submit']")
    WebElement payBtn;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // ✅ INIT
        PageFactory.initElements(driver, this);
    }

    public void pay() {

        wait.until(ExpectedConditions.visibilityOf(name)).sendKeys("Sourabh Card");
        card.sendKeys("4242424242424242");
        cvc.sendKeys("123");
        month.sendKeys("12");
        year.sendKeys("2029");

        // wait until button is present in DOM
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.id("submit")));

        // use JS util (handles ads + scroll + click)
        JsUtil.safeClick(driver, payBtn);
    }

}
