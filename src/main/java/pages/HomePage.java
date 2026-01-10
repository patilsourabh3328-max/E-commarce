package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@href='/products']")
    WebElement products;

    @FindBy(xpath = "//a[contains(text(),'Signup')]")
    WebElement signupLogin;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void clickSignupLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(signupLogin)).click();
    }

    public void clickProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(products)).click();
    }
}
