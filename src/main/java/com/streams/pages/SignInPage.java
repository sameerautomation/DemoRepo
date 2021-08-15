package com.streams.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.streams.basepage.BasePage;

public class SignInPage 
{

	public WebDriver driver;
	
	public SignInPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//PageFactory or Object Repository
	
	@FindBy(id="xusername")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login_button")
	WebElement login_button;
	
	

	//Methods to perform actions
	
	public String validateSignInPageUrl()
	{
		return driver.getCurrentUrl();
	}
	
	
	public HomePage login(String uname, String pwd, String inputdata, String expected) throws InterruptedException
	{
		username.sendKeys(uname);
		password.sendKeys(pwd);
		login_button.click();
		return new HomePage(driver);
	}
	
	
}
