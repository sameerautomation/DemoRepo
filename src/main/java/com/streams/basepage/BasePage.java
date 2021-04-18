package com.streams.basepage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasePage 
{

	public  static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;


		public BasePage()
	{

		try 
		{
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\streams\\configurations\\config.properties");
		    prop=new Properties();
			prop.load(fis);		
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		 catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

		
	public static void launchBrowser() 
	{	
		
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
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}




}
