package com.streams.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sync 
{


	public static void elementToBeClickable( WebDriver driver,int time, WebElement Locator)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.elementToBeClickable(Locator));
	}


	public static void visibilityOf(WebDriver driver, int time, WebElement Locator) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(Locator));
	}



	public static void invisibilityOf(WebDriver driver, int time, WebElement Locator) 
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.invisibilityOf(Locator));
	}


	
	public static void alertIsPresent(WebDriver driver, int time) 
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.alertIsPresent());
	}


	public static void titleContains(WebDriver driver, int time, WebElement Locator, String title)
	{
		WebDriverWait wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.titleContains(title));
	}









}
