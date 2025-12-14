package com.Ecommerce.testcases;

import org.testng.annotations.Test;

import com.Ecommarce.PageObject.LoginPage;
import com.Ecommarce.PageObject.indexPage;

public class TC_VerifyLoginPage extends BaseClass {

	
	@Test
	public void Verifylogin() {
		
		driver.get(baseUrl);
		logger.info("url open");
		
		indexPage pg= new indexPage(driver);
		
		pg.ClickOnSigninButton();
		logger.info("clicked on signinButton button");
		
		LoginPage p=new LoginPage(driver);
		p.enterEmailAddress("patlsourabh3328@gmail.com");
		logger.info("enteedrEmailAddress");
		
		p.enterPassword("sourabh@1");
		logger.info("enteedrEmailAddress");
		
		
		p.ClickOnloginButton();
		logger.info("ClickOnloginButton");
		
	}
	
	
}
