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

public class ExtentListenerClass implements ITestListener {

    ExtentSparkReporter htmlReporter;
    ExtentReports reports;
    ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // Use ThreadLocal for parallel execution

    public void configureReport() {
        ReadConfig readConfig = new ReadConfig();
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "MyStoreTestReport-" + timestamp + ".html";
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/Reports/" + reportName);
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);

        // System info
        reports.setSystemInfo("Machine", "testpc1");
        reports.setSystemInfo("OS", "Windows 11");
        reports.setSystemInfo("Browser", readConfig.getbrowser());
        reports.setSystemInfo("User Name", "Sourabh");

        // Report look & feel
        htmlReporter.config().setDocumentTitle("Extent Listener Report Demo");
        htmlReporter.config().setReportName("Ecommerce Test Report");
        htmlReporter.config().setTheme(Theme.DARK);
    }

    @Override
    public void onStart(ITestContext context) {
        configureReport();
        System.out.println("On Start method invoked...");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("On Finish method invoked...");
        reports.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test Started: " + result.getName());
        ExtentTest extentTest = reports.createTest(result.getName());
        test.set(extentTest); // Store in ThreadLocal
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed: " + result.getName());
        test.get().log(Status.PASS, MarkupHelper.createLabel("Test Passed: " + result.getName(), ExtentColor.GREEN));
    }

<<<<<<< HEAD
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
		
			
=======
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());
        test.get().log(Status.FAIL, MarkupHelper.createLabel("Test Failed: " + result.getName(), ExtentColor.RED));
        test.get().fail(result.getThrowable());
>>>>>>> PP

        // Capture screenshot
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotPath = System.getProperty("user.dir") + "/Screenshots/" + result.getName() + "_" + timestamp + ".png";

        try {
            TakesScreenshot ts = (TakesScreenshot) BaseClass.driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotPath);
            dest.getParentFile().mkdirs();
            FileUtils.copyFile(src, dest);

            // Attach screenshot to the test
            test.get().fail("Screenshot of failure", com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped: " + result.getName());
        test.get().log(Status.SKIP, MarkupHelper.createLabel("Test Skipped: " + result.getName(), ExtentColor.YELLOW));
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Not used
    }
}
