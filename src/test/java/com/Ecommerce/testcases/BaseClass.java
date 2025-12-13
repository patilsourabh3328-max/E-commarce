package com.Ecommerce.testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import com.Ecommarce.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {

	ReadConfig readconfig=new ReadConfig();	
	
	String url=readconfig.getbaseUrl();		
	String browser=readconfig.getbrowser();

	public static WebDriver driver;
	@BeforeClass
	public void setup()
	{

		//launch browser
		switch(browser.toLowerCase())
		{
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
			driver = null;
			break;

		}

		//implicit wait of 10 secs
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
	}
	
}
