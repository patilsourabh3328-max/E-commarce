package com.Ecommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecommarce.PageObject.LoginPage;
import com.Ecommarce.PageObject.indexPage;

public class TC_VerifyLoginPage extends BaseClass {

	
	@Test
	public void Verifylogin() throws InterruptedException {
		
		driver.get(baseUrl);
		logger.info("url open");
		
		indexPage pg= new indexPage(driver);
		
		pg.ClickOnSigninButton();
		logger.info("clicked on signinButton button");
		
		LoginPage p=new LoginPage(driver);
		p.enterEmailAddress("patilsourabh3328@gmail.com");
		logger.info("enteedrEmailAddress");
		
		p.enterPassword("sourabh@1");
		logger.info("enteedr Password");
		
		
		p.ClickOnloginButton();
		logger.info("ClickOnloginButton");
		
		Thread.sleep(2000);
		LoginPage regUser = new LoginPage(driver);
		String userName = regUser.getUserName();

		Assert.assertEquals("sourabh", userName);

		logger.info("***************TestCase Verify Registration and Login ends*****************"); 
		
		p.ClickonSignOut();
		logger.info("SignOut");
	}
	
	
	
}
