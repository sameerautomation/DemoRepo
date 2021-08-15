package com.streams.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage 
{

	public WebDriver driver;
	public FileInputStream fis;
	public Properties prop;


	public WebDriver launchBrowser()  
	{	
			
		try 
		{
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\streams\\configurations\\config.properties");
		} 
		catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		prop=new Properties();
		
		try 
		{
			prop.load(fis);
		} 
		catch (IOException e) 
		{
			
			e.printStackTrace();
		}	

		String browsername=prop.getProperty("browser");
		
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();	
		}else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		return driver;
		
	}


	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports"+File.separator+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));	
		return destinationFile;
	}


}
