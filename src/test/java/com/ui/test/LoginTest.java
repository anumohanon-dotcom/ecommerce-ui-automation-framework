package com.ui.test;

import static org.testng.Assert.*;

import java.sql.Driver;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.ui.pojo.User;
import com.utility.BrowserUtility;
import com.utility.LoggerUtility;
@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase {
	

	@Test(description="this test verifies whether valid user is able to login" , groups= {"e2e","sanity"},dataProviderClass = com.ui.dataProviders.LoginDataProvider.class,dataProvider = "LoginTestDataProvider",
			retryAnalyzer = com.ui.listeners.MyRetryAnalyser.class)
	public void Logintest1(User user){
		
		
		assertEquals(homepage.goToSigninPage().doLoginWith(user.getEmailaddress(),user.getPassword()).getUserName(), "Rohan rahan");
		
	}
	
}
