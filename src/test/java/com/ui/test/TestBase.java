package com.ui.test;

import static com.constants.Browser.CHROME;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;

public class TestBase {
	
	
	protected HomePage homepage;
	private boolean isLambdatest;
	private boolean isheadless;
	
	
	@Parameters({"browser","isLambdatest","isheadless"})
	@BeforeMethod(description="Load the home page")
	public void SetUp(
			@Optional("CHROME") String browser,
			@Optional("true") boolean isLambdatest,
			@Optional("false") boolean isheadless,ITestResult result) {
		this.isLambdatest=isLambdatest;
		WebDriver lambdadriver;
		if(isLambdatest)
		{
			lambdadriver=LambdaTestUtility.initialiseLambdaTest("chrome", result.getMethod().getMethodName());
			homepage=new HomePage(lambdadriver);
		}
		
		else
		{
		homepage=new HomePage(CHROME,isheadless);
		
	}
	}
	
	

	public BrowserUtility getInstance() {
		return homepage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		if(isLambdatest)
		{
			LambdaTestUtility.quitSession();//close browser session on lambda test
		}
		else
		{
		homepage.quitd();
	}

}
}
