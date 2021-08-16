package com.streams.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.streams.basepage.BasePage;
import com.streams.utilities.Sync;

public class HomePage 
{

	public WebDriver driver;

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	
	
	//PageFactory or Object Repository


	@FindBy(id="streams_menu_icon_area")
	WebElement threebarmenu;

	@FindBy(xpath="//li[text()=' Logout']")
	WebElement logoutbutton;

	@FindBy(id="spaneltabanc_3")
	WebElement smartboxicon;
	
	@FindBy(xpath="//*[@id=\"wedrive_newfolder_icon_enable\"]/a")
	WebElement createnewfolder;
	
	@FindBy(xpath="//input[@id='webdrive_createfolder']")
	WebElement foldernametextbox;
	
	@FindBy(xpath="//input[@value='Create']")
	WebElement create;
	
	/*@FindBy(id="webdrive_loading")
	WebElement loadericon;*/
	
	@FindBy(xpath="//div[@id='spanel_3']/div")
	WebElement loadericon;
	
	
	@FindBy(xpath="//span[@class='SBFileName textLimit spaceToLeftForListView']")
	List<WebElement> folderslist;
	
	
	
	//Methods

	public String getHomePageUrl()
	{
		return driver.getCurrentUrl();
	}

	public void clickOnThreeBarMenu()
	{
		threebarmenu.click();
	}

	
	public void clickOnLogOutButton()
	{
		logoutbutton.click();
	}	
	
	
	public String createFolder() throws InterruptedException
	{
		smartboxicon.click();	
	    Sync.visibilityOf(driver, 30, loadericon);
	    Sync.invisibilityOf(driver, 40, loadericon);
		String foldername = "fan" + System.currentTimeMillis();
		createnewfolder.click();
		foldernametextbox.sendKeys(foldername);
		create.click();
		Thread.sleep(60000);
		System.out.println("returning the list");
		return folderslist.get(0).getText();		
		
	}
	
	
	
	

}
