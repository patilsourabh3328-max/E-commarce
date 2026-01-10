package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import utils.JsUtil;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    By placeOrderBtn = By.cssSelector("a.btn.btn-default.check_out");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void placeOrder() {

        // Hide ads
        JsUtil.hideAds(driver);

        WebElement button = wait.until(
            ExpectedConditions.elementToBeClickable(placeOrderBtn)
        );

        // Scroll + click
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", button);

        button.click();
    }
}
