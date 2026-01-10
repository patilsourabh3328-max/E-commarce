package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class ProductDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//button[contains(@class,'cart')]")
    WebElement addToCartBtn;

    @FindBy(xpath = "//h4[text()='Added!']")
    WebElement addedMsg;

    @FindBy(xpath = "//u[text()='View Cart']")
    WebElement viewCartLink;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {

        // 🔥 Scroll into view (VERY IMPORTANT)
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", addToCartBtn);

        wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();

        // Wait for modal confirmation
        wait.until(ExpectedConditions.visibilityOf(addedMsg));

        // Click View Cart from modal
        viewCartLink.click();
    }
}
