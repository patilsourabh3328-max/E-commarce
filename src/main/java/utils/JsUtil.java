package utils;

import org.openqa.selenium.*;

public class JsUtil {

    public static void hideAds(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript(
            "document.querySelectorAll(" +
            "\"iframe[id^='aswift'], iframe[src*='ads'], iframe[title='Advertisement']\"" +
            ").forEach(e => e.style.display='none');"
        );
    }

    public static void safeClick(WebDriver driver, WebElement element) {
        hideAds(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block:'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }
}
