package com.utility;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
	public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver initialiseLambdaTest(String browser, String testname) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", browser);
		capabilities.setCapability("browserVersion", "latest");
		Map<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("user", "anumohanon");
		ltOptions.put("accessKey", "LT_KqbXEsEhHpTkJsg5aEQPhQM89ngzmixfga1LTgCuyk49wq8");
		ltOptions.put("build", "Selenium 4");
		ltOptions.put("name", testname);
		ltOptions.put("platformName", "Windows 10");
		ltOptions.put("seCdp", true);
		ltOptions.put("selenium_version", "latest");
		capabilities.setCapability("LT:Options", ltOptions);
		capabilitiesLocal.set(capabilities);
       WebDriver driver;
	try {
		driver = new RemoteWebDriver(new URI(HUB_URL).toURL(), capabilitiesLocal.get());
		driverlocal.set(driver);
	} catch (MalformedURLException | URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return driverlocal.get();
		
	}
	
	public static void quitSession()
	{
		if(driverlocal.get()!=null)
		{
			driverlocal.get().quit();
		}
	}
}
