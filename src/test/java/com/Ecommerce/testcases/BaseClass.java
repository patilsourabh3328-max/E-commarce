package com.Ecommerce.testcases;

import java.time.Duration;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import com.Ecommarce.Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;
    public static Logger logger;

    ReadConfig readconfig;
    String baseUrl;
    String browser;

    @BeforeClass
    public void setup() {

        readconfig = new ReadConfig();     // ✅ safe
        baseUrl = readconfig.getbaseUrl();
        browser = readconfig.getbrowser();

        switch (browser.toLowerCase()) {
        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        case "msedge":
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            break;
        case "firefox":
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            break;
        default:
            throw new RuntimeException("Invalid browser in config file");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logger = LogManager.getLogger("com.Ecommarce");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
