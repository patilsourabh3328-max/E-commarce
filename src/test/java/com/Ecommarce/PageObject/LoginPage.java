package com.Ecommarce.PageObject;

import java.util.jar.Attributes.Name;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// create object of webdriver -1
	WebDriver ldriver;

	// in erery page class this constructor name changes-2 {in erery page 1&2
	// Required}
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	// identify WebElements for All Pages

	@FindBy(name = "email")
	WebElement Email;

	@FindBy(name = "password")
	WebElement Password;

	@FindBy(xpath = "//*[text()='Login1111111']")
	WebElement LoginButton;

	// identify action on webelement

	public void enterEmailAddress(String emailAdd) {
		Email.sendKeys(emailAdd);
	}

	public void enterPassword(String emailAdd) {
		Password.sendKeys(emailAdd);
	}

	public void ClickOnloginButton() {
		LoginButton.click();
	}

}
