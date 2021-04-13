//author sameer

package com.streams.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.streams.basepage.BasePage;
import com.streams.pages.HomePage;
import com.streams.pages.SignInPage;
import com.streams.utilities.TestUtil;

public class SignInPageTest extends BasePage
{
	HomePage homepage; 
	SignInPage signinpage;
	TestUtil xlutility;



	/*public SignInPageTest()
	{
		super();
	}*/


	@BeforeMethod
	public void setUp()
	{
		launchBrowser();
		signinpage= new SignInPage();
	}



	@Test(priority=0)
	public void validateSignInPageUrlTest()
	{
		String actualurl=signinpage.validateSignInPageUrl();
		Assert.assertEquals(actualurl, "https://accounts.unifiedcloudit.com/auth/?dashboardid=302922967&svid=10&src=streams.us&se=true");
	}	



	@Test(priority=1, dataProvider="getData")
	public void logintest(String uname, String pwd, String inputdata, String expected)
	{
		homepage=signinpage.login(uname, pwd, inputdata, expected);
		String actualurl=homepage.getHomePageUrl();
		if(inputdata.equals("valid"))
		{
			if(expected.equals(actualurl))
			{
				homepage.clickOnThreeBarMenu();
				homepage.clickOnLogOutButton();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
			
		}
		else if(inputdata.equals("invalid"))
		{
			if(expected.equals(actualurl))
			{
				Assert.assertTrue(true);
			}
			else
			{		
				homepage.clickOnThreeBarMenu();
				homepage.clickOnLogOutButton();
				Assert.assertTrue(false);
			}
		}
	}


	//SDET
	@DataProvider
	public Object[][] getData() throws IOException
	{	
		String path=System.getProperty("user.dir") + "/src/main/java/com/streams/testdata/logindata.xlsx" ;

		xlutility=new TestUtil(path);

		int totalrowscount=xlutility.getRowCount("Sheet1");
	
		int totalcolumnscount=xlutility.getCellCount("Sheet1", 1);
	
		//Create a two dimensional array of object type	

		Object[][] loginData=new Object[totalrowscount-1][totalcolumnscount];     


		for(int i=1; i<totalrowscount; i++)
		{
			for(int j=0; j<totalcolumnscount; j++)
			{

				loginData[i-1][j]=xlutility.getCellData("Sheet1", i, j);

			}
		}

		return loginData;
	}




	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
