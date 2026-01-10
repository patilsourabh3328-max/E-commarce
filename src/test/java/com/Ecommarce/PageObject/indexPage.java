package com.Ecommarce.PageObject;

import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class indexPage {

	// create object of webdriver 
	 WebDriver ldriver;
	 
	 public indexPage(WebDriver rdriver) {
		 ldriver =rdriver;
		 PageFactory.initElements(rdriver, this);
		 
	 }
	
	 //identify WebElements for All Pages 
	 
     @FindBy(xpath  = "//*[text()=' Signup / Login']")
     WebElement SignIn;
     
	 
	//identify action on webelement
     
     public void ClickOnSigninButton() {
    	 SignIn.click();
     }
     
     
	
}
