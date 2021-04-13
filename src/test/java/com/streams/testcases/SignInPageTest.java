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
	public void logintest(String username, String password)
	{
		homepage=signinpage.login(username, password);
	}


	//SDET
	@DataProvider
	public String[][] getData() throws IOException
	{	
		String path=System.getProperty("user.dir") + "/src/main/java/com/streams/testdata/logindata.xlsx" ;

		xlutility=new TestUtil(path);

		int totalrowscount=xlutility.getRowCount("Sheet1");
	
		int totalcolumnscount=xlutility.getCellCount("Sheet1", 1);
	
		//Create a two dimensional array of object type	

		String[][] loginData=new String[totalrowscount-1][totalcolumnscount];     


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
