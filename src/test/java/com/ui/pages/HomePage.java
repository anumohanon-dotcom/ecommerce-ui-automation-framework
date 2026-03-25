package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.constants.Env;

import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility {
	
	 public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.jsonReader(QA).getUrl());
	}

	 public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite(JSONUtility.jsonReader(QA).getUrl());
		//goToWebsite(PropertiesUtil.properties(QA, "URL"));
		
	}
	 

	 
	 
	 public HomePage(Browser browserName, boolean isheadless) {
		 super(browserName,isheadless);
		 goToWebsite(JSONUtility.jsonReader(QA).getUrl());
		
	}




	 private static final By LOGIN_LOCATOR=By.className("login");
	
	 public LoginPage goToSigninPage()
	 {
		 clickOn(LOGIN_LOCATOR);
		 LoginPage loginpage=new LoginPage(getDriver());
		 return loginpage;
		 
	 }
	 
	 
	 
	 public void quitd()
	 {
		 quitdriverb();
	 }
	 
	 

}
