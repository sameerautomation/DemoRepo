package com.streams.testcases;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.streams.basepage.BasePage;
import com.streams.pages.HomePage;
import com.streams.pages.SignInPage;

public class HomePageTest extends BasePage
{
	public static Logger log =LogManager.getLogger(HomePageTest.class.getName());
	
	SignInPage signinpage;
	HomePage homepage;
	
	@BeforeMethod
	public void setUp()
	{
		driver=launchBrowser();
		log.info("browser launched sucessfully");
		
	}
	
	
	@Test(priority=1)
	public void createFolder() throws InterruptedException
	{
		signinpage= new SignInPage(driver);
		signinpage.login("sameerone@accountvalidation", "abc@1234", "valid", "https://streams.us/sloader/home.jsp");
		homepage= new HomePage(driver);
		String flag=homepage.createFolder();
		if(flag.contains("fan"))
		{
			Assert.assertTrue(true);
			log.info("folder created sucessfully");
		}
		else
		{
			Assert.assertTrue(false);
		}
	}	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
