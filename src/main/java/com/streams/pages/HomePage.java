package com.streams.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.streams.basepage.BasePage;

public class HomePage extends BasePage
{

	//PageFactory or Object Repository
	
	@FindBy(id="streams_menu_icon_area")
	WebElement threebarmenu;
	
	@FindBy(xpath="//li[text()=' Logout']")
	WebElement logoutbutton;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
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
	
}
