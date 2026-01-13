package com.Ecommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Ecommarce.PageObject.CartPage;
import com.Ecommarce.PageObject.CheckoutPage;
import com.Ecommarce.PageObject.HomePage;
import com.Ecommarce.PageObject.LoginPage;
import com.Ecommarce.PageObject.PaymentPage;
import com.Ecommarce.PageObject.ProductDetailsPage;
import com.Ecommarce.PageObject.ProductsPage;
import com.Ecommarce.PageObject.indexPage;


public class TC_VerifyE2EFlow extends BaseClass {

	@Test
	public void VerifyAllFlow() throws InterruptedException {
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
    
	logger.info("Click on ProductPage Button");
    HomePage ho=new HomePage(driver);
    ho.clickProducts();
    logger.info("Clicked onProduct Button");
    
    
    ProductsPage prod=new ProductsPage(driver);
    prod.searchProduct("Men tshirt");
    prod.viewFirstProduct();
    
    ProductDetailsPage pd=new ProductDetailsPage(driver);
    pd.addProductToCart();
  
    logger.info("CartPage_Start");
	 CartPage cartPage = new CartPage(driver);
     cartPage.goToCheckout();
     logger.info("CartPage_End");
     
     logger.info("CheckOutPage_Start");
     CheckoutPage checkoutPage = new CheckoutPage(driver);
     checkoutPage.placeOrder();
     logger.info("CheckOutPage_End");

     logger.info("PaymentPage_Start");
     PaymentPage payment = new PaymentPage(driver);
     payment.pay();
     logger.info("PaymentPage_End");

}
}