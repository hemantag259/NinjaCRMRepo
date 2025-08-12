package ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseTest.BaseClass;

public class ListenerImplementation implements ISuiteListener,ITestListener {
    
	
	public ExtentReports reports;
	public ExtentSparkReporter spark;
	public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		
		Reporter.log("Report Configuration",true);
		Date d=new Date();
	    String newDate = d.toString().replace(" ", "_").replace(":", "_");
	    
	   spark=new ExtentSparkReporter("target/AdvanceReport/report"+newDate+".html");
	   spark.config().setDocumentTitle("Ninja CRM Test Suite");
	   spark.config().setReportName("CRM Report");
	   spark.config().setTheme(Theme.DARK);
	   
	   reports=new ExtentReports();
	   reports.attachReporter(spark);
	   reports.setSystemInfo("OS", "Windows 10");
	   reports.setSystemInfo("Browser", "Edge");
		
		
	}

	@Override
	public void onFinish(ISuite suite) {
		Reporter.log("Report Backup",true);
		reports.flush();
		
	}
	@Override
	public void onTestStart(ITestResult result) {
		
		test=reports.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "======"+result.getMethod().getMethodName()+"Execution Started====");
		//Reporter.log("======"+result.getMethod().getMethodName()+"Execution Started====",true);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "======"+result.getMethod().getMethodName()+"Success====");
		//Reporter.log("======"+result.getMethod().getMethodName()+"Success====",true);

	}

	@Override
	public void onTestFailure(ITestResult result) {
       //Reporter.log("======="+result.getMethod().getMethodName()+"Failed");
       Date d=new Date();
	    String newDate = d.toString().replace(" ", "_").replace(":", "_");
		String testName=result.getMethod().getMethodName();
		TakesScreenshot ts=(TakesScreenshot) BaseClass.sdriver;
		String temp=ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp,testName+newDate);
		test.log(Status.FAIL, "======="+result.getMethod().getMethodName()+"Failed==========");
	
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "======"+result.getMethod().getMethodName()+"Execution Skipped====");
		//Reporter.log("======"+result.getMethod().getMethodName()+"Execution Skipped====",true);
	
	}

	
	

}
