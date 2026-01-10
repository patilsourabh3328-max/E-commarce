package com.Ecommerce.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Ecommarce.PageObject.LoginPage;
import com.Ecommarce.PageObject.indexPage;
import com.Ecommarce.Utilities.ReadExcelFile;

public class TC_VerifyLoginPageDataDriven extends BaseClass {

	
	@Test (dataProvider = "LoginData")
	public void Verifylogin(String Username , String UserPass , String ExpUsername) throws InterruptedException {	
	
		//index Page element
		
		Thread.sleep(200);
		indexPage pg= new indexPage(driver);
		pg.ClickOnSigninButton();
		logger.info("clicked on signinButton button");
		
		//login Page element
		
		LoginPage p=new LoginPage(driver);
		p.enterEmailAddress(Username);
		logger.info("enteedrEmailAddress");
		
		p.enterPassword(UserPass);
		logger.info("enteedrPassword");
		
		p.ClickOnloginButton();
		logger.info("ClickOnloginButton");
		
		Thread.sleep(300);
		String userName = p.getUserName();

		if(userName.equals(ExpUsername))
		{
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
			
			p.ClickonSignOut();
			
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			Assert.assertTrue(false);

		} 
			 
		logger.info("***************TestCase Verify login ends*****************"); 
	}
	
	@DataProvider(name = "LoginData")
	public Object[][] LoginData() {

	    String fileName = System.getProperty("user.dir")
	            + "\\Testdata\\LoginPageData.xlsx";

	    int ttlRows = ReadExcelFile.getRowCount(fileName, "Sheet1");
	    int ttlColumns = ReadExcelFile.getColCount(fileName, "Sheet1");

	    System.out.println("Rows: " + ttlRows);
	    System.out.println("Columns: " + ttlColumns);

	    if (ttlRows <= 1) {
	        throw new RuntimeException("No test data found in Excel");
	    }

	    Object[][] data = new Object[ttlRows - 1][ttlColumns];

	    for (int i = 1; i < ttlRows; i++) {
	        for (int j = 0; j < ttlColumns; j++) {
	            data[i - 1][j] =
	                ReadExcelFile.getCellValue(fileName, "Sheet1", i, j);
	        }
	    }
	    return data;
	}

			}
		
		
		
	
	
	

