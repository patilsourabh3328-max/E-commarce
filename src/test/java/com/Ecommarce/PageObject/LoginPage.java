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

	@FindBy(xpath = "//*[text()='Login']")
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

	
	@FindBy(xpath="/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[10]/a[1]/b[1]")
	WebElement ExpectedUsername;
	
	public String getUserName()
	{
		String text = ExpectedUsername.getText();

		return text;
	}
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement Signout;
	
	public void ClickonSignOut() {
		Signout.click();
	}
}
