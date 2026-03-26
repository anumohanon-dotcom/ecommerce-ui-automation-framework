package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	
	
	private static  ThreadLocal<WebDriver> driver=new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);//initialize webdriver
	}
	
	public BrowserUtility(Browser browser)
	{
		if(browser==Browser.CHROME)
		{
			driver.set(new ChromeDriver());
		}
		else if(browser==Browser.EDGE)
		{
			driver.set(new EdgeDriver());
		}
		else if(browser==Browser.FIREFOX)
		{
			driver.set(new FirefoxDriver());
		}
		else
		{
			System.err.println("Invalid browser name");
		}
	}
	
	public BrowserUtility(Browser browser,boolean isHeadless)
	{
		if(browser==Browser.CHROME)
		{
			if(isHeadless)
			{
			ChromeOptions options=new ChromeOptions();
			options.addArguments("--headless=old");
			options.addArguments("--window-size=1920,1080");
			driver.set(new ChromeDriver(options));
		}
			else
			{
				driver.set(new ChromeDriver());
			}
		}
		else if(browser==Browser.EDGE)
		{
			if(isHeadless)
			{
			EdgeOptions options=new EdgeOptions();
			options.addArguments("--headless=old");
			options.addArguments("disable-gpu");
			driver.set(new EdgeDriver(options));
		}
			else
			{
				driver.set(new EdgeDriver());
			}
		}
			
		else if(browser==Browser.FIREFOX)
		{if(isHeadless)
		{
		FirefoxOptions options=new FirefoxOptions();
		options.addArguments("--headless=old");
		options.addArguments("disable-gpu");
		driver.set(new FirefoxDriver(options));
		}
		else
		{
			driver.set(new FirefoxDriver());
		}
		}
		else
		{
			System.err.println("Invalid browser name");
		}
	}
	
	public void goToWebsite(String url)
	{
		driver.get().get(url);
	}
	
	public void maximiseWindow()
	{
		//maximise the window
				driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator)
	{
		WebElement element=driver.get().findElement(locator);
		element.click();
	}
	
	
	public void enterText(By locator,String text )
	{
		WebElement element=driver.get().findElement(locator);
		element.sendKeys(text);
	}
	
	public String getVisibleTest(By locator)
	{
		
		WebElement element=driver.get().findElement(locator);
		return element.getText();
	}
	
	public void quitdriverb()
	{
		driver.get().quit();
	}
	
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat simpledateformat = new SimpleDateFormat("HH-mm-ss");
		String timestamp = simpledateformat.format(date);
		String path =  "./screenshot/" + name + "-" + timestamp + ".png";
		File screenhotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenhotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;

	}
	
	
	
	
	

}
