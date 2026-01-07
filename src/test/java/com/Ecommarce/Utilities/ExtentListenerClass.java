package com.Ecommarce.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Ecommerce.testcases.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ExtentListenerClass implements ITestListener{

	ExtentSparkReporter  htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport()
	{
		ReadConfig readConfig = new ReadConfig();
		String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String reportName = "MyStoreTestReport-" + timestamp + ".html";
		htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + reportName);
		reports = new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		//add system information/environment info to reports
		reports.setSystemInfo("Machine:", "testpc1");
		reports.setSystemInfo("OS", "windows 11");
		reports.setSystemInfo("browser:", readConfig.getbrowser());
		reports.setSystemInfo("user name:", "Sourabh");
		
		//configuration to change look and feel of report
		htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
		htmlReporter.config().setReportName("Ecommarce");
		htmlReporter.config().setTheme(Theme.DARK);
		
		
	}

	//OnStart method is called when any Test starts.
	public void onStart(ITestContext Result)					
	{		
		configureReport();
		System.out.println("On Start method invoked....");  		
	}	

	//onFinish method is called after all Tests are executed
	public void onFinish(ITestContext Result) 					
	{		
		System.out.println("On Finished method invoked....");  	
		reports.flush();//it is mandatory to call flush method to ensure information is written to the started reporter.

	}		



	// When Test case get failed, this method is called.		

	@Override
	public void onTestFailure(ITestResult result) {

	    System.out.println("Name of test method failed: " + result.getName());

	    // Create test entry in Extent report
	    test = reports.createTest(result.getName());
	    test.log(Status.FAIL, MarkupHelper.createLabel("Test Case Failed: " + result.getName(), ExtentColor.RED));

	    // Timestamp for unique file names
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

	    // Screenshot folder path
	    String screenshotPath = System.getProperty("user.dir") + "\\Screenshots\\" + result.getName() + "_" + timestamp + ".png";

	    try {
	        // Capture Screenshot
	        TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;   // <-- driver reference
	        File src = ts.getScreenshotAs(OutputType.FILE);
	        File dest = new File(screenshotPath);

	        // Create folder automatically
	        dest.getParentFile().mkdirs();

	        FileUtils.copyFile(src, dest);

	        // Attach screenshot in report
	        test.fail("Screenshot of failure: ").addScreenCaptureFromPath(screenshotPath);

	    } catch (Exception e) {
	        System.out.println("Exception while taking screenshot: " + e.getMessage());
	    }
	}

	
	//	test.addScreenCaptureFromPath(null)
		
			

	// When Test case get Skipped, this method is called.


	// When Test case get Skipped, this method is called.		

	public void onTestSkipped(ITestResult Result)					
	{		
		System.out.println("Name of test method skipped:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel("Name of the skip test case is: " + Result.getName() ,ExtentColor.YELLOW));
	}			

	// When Test case get Started, this method is called.		

	public void onTestStart(ITestResult Result)					
	{		
		System.out.println("Name of test method started:" + Result.getName() );  		

	}		

	// When Test case get passed, this method is called.		

	public void onTestSuccess(ITestResult Result)					
	{		
		System.out.println("Name of test method sucessfully executed:" + Result.getName() );  		

		test = reports.createTest(Result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of the passed test case is: " + Result.getName() ,ExtentColor.GREEN));
	}		


	public void onTestFailedButWithinSuccessPercentage(ITestResult Result)					
	{		

	}		


	
}
