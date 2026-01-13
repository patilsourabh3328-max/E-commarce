package com.Ecommarce.PageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utils.JsUtil;

import java.time.Duration;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(id = "search_product")
    WebElement searchBox;

    @FindBy(id = "submit_search")
    WebElement searchBtn;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    WebElement viewProduct;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(product);
        searchBtn.click();
    }

    public void viewFirstProduct() {
        wait.until(ExpectedConditions.visibilityOf(viewProduct));
        JsUtil.safeClick(driver, viewProduct);
    }
}
