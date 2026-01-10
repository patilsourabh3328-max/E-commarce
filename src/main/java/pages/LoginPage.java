package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement email;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    WebElement password;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    WebElement loginBtn;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login(String user, String pass) {
        email.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }
}
