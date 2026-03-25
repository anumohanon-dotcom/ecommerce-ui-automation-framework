package com.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	private static ExtentReports extentReports;
	private static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	
	public static void setupSparkReporter(String reportName)
	{
		ExtentSparkReporter extendsparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//"+reportName );
		extentReports = new ExtentReports();
		extentReports.attachReporter(extendsparkReporter);
	}
	
	public static void createExtentTest(String Testname)
	{
		ExtentTest test=extentReports.createTest(Testname);
		extentTest.set(test);
	}
	
	public static ExtentTest getTest()
	{
		return extentTest.get();
	}
	
	
	public static void flushreport()
	{
		extentReports.flush();
	}

}
