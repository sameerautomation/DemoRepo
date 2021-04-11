//author sameer

package com.streams.testcases;

import java.io.IOException;

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
	TestUtil xlutils;

	@DataProvider
	public Object[][] getloginData() throws IOException
	{	
		String path=System.getProperty("user.dir") + "\\src\\main\\java\\com\\streams\\testdata\\logindata.xlsx" ;

		 xlutils=new TestUtil(path);

		int totalrowscount=xlutils.getRowCount("logindata");
		System.out.println(totalrowscount);

		int totalcolumnscount=xlutils.getCellCount("logindata", 1);
		System.out.println(totalcolumnscount);

		//Create a two dimensional array of object type	

		Object[][] loginData=new Object[totalrowscount-1][totalcolumnscount];     
																				      

		for(int i=1; i<totalrowscount; i++)
		{
			for(int j=0; j<totalcolumnscount; j++)
			{

				loginData[i-1][j]=xlutils.getCellData("logindata", i, j);

			}
		}

		return loginData;
	}


	public SignInPageTest()
	{
		super();
	}


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
	
	
	

	
	
	@Test(priority=1)
	public void logintest()
	{
		homepage=signinpage.login("sameerone@accountvalidation",  "abc@1234");
	}
	

		

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}
