package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;

public class TestListener implements ITestListener {
	Logger logger = LoggerUtility.getLogger(this.getClass());

	ExtentSparkReporter extendsparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	public void onStart(ITestContext context) {
		logger.info("Test Suite started");
		ExtentReportUtility.setupSparkReporter("report.html");
	}

	

	public void onTestStart(ITestResult result) {

		logger.info(result.getMethod().getMethodName() + "  Started");
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		logger.info("Test class: " + result.getTestClass().getRealClass().getSimpleName());
		logger.info("Test method: " + result.getMethod().getMethodName());
		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + "  Passed");
		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + "  Passed");

	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + "  Failed");
		logger.error(result.getThrowable().getMessage());
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "  Failed");
		ExtentReportUtility.getTest().log(Status.FAIL,result.getThrowable().getMessage());
		
		Object testclass=result.getInstance();
		BrowserUtility br=((TestBase)testclass).getInstance();
		String screenshotpath=br.takeScreenshot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotpath);

	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "Skipped");
		ExtentReportUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "Skipped");

	}
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Finished");
		ExtentReportUtility.flushreport();
	}

	

}
