package com.ui.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	
	}
	
	private static final By EMAIL_LOCATOR=By.id("email");
	private static final By PASSWORD_LOCATOR=By.id("passwd");
	private static final By SUBMIT_LOCATOR=By.cssSelector("button[id=\"SubmitLogin\"]");
	
	public MyAccount doLoginWith(String userName,String passWord)
	{
		enterText(EMAIL_LOCATOR, userName);
		enterText(PASSWORD_LOCATOR, passWord);
		clickOn(SUBMIT_LOCATOR);
		MyAccount myaccount=new MyAccount(getDriver());
		return myaccount;
	}
	
	
	

}
