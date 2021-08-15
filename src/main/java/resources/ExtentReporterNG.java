package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	static ExtentReports extent;
	
	
	public static ExtentReports getReportObject()
	{
		// ExtentReports , ExtentSparkReporter

		String path =System.getProperty("user.dir")+"\\reports\\index.html";

		ExtentSparkReporter reporter = new ExtentSparkReporter(path);

		reporter.config().setReportName("Web Automation Results");

		reporter.config().setDocumentTitle("Test Results");

		//Create an object for ExtentReports class
		
		extent=new ExtentReports();

		extent.attachReporter(reporter);

		extent.setSystemInfo("Tester", "Sameer");
		
		return extent;
	}
	
	
	
	
}
