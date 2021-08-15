package com.streams.utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.streams.basepage.BasePage;

import resources.ExtentReporterNG;

public class Listeners extends BasePage implements ITestListener 
{
	String screenshotpath;
	ExtentReports extent=ExtentReporterNG.getReportObject();
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) 
	{
		 test=extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
	}

	public void onTestSuccess(ITestResult result) 
	{
		extentTest.get().log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) 
	{
		extentTest.get().log(Status.FAIL, result.getThrowable());
		
		WebDriver driver=null;
		//get the testmethod name which got failed
		String testMethodName=result.getMethod().getMethodName();
		try 
		{
			//get the driver which has life from the failed testclass
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		
		try 
		{
			screenshotpath=getScreenshot(testMethodName, driver);
			extentTest.get().addScreenCaptureFromPath(screenshotpath, result.getMethod().getMethodName());
						
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) 
	{

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{

	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{

	}

	public void onStart(ITestContext context) 
	{

	}

	public void onFinish(ITestContext context) 
	{
		extent.flush();
	}




}
