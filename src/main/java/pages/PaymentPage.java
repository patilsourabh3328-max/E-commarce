package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class PaymentPage {

    WebDriver driver;

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

    @FindBy(id = "submit")
    WebElement payBtn;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void pay() {
        name.sendKeys("Sourabh Card");
        card.sendKeys("4242424242424242");
        cvc.sendKeys("123");
        month.sendKeys("12");
        year.sendKeys("2029");
        payBtn.click();
    }
}
