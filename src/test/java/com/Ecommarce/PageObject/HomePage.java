package com.Ecommarce.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	// create object of webdriver 
	WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }
	 
	 @FindBy(xpath = "//a[@href='/products']")
	    WebElement products;
	 
	 public void clickProducts() {
	        wait.until(ExpectedConditions.elementToBeClickable(products)).click();
	    }
}
