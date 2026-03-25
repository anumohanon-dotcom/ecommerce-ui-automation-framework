package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public class MyRetryAnalyser implements IRetryAnalyzer{
	
	//public static final int MAX_NUMBER_OF_ATTEMPT=Integer.parseInt(PropertiesUtil.properties(Env.QA, "MAX_NUMBER_OF_ATTEMPT"));
	
	public static final int MAX_NUMBER_OF_ATTEMPT=JSONUtility.jsonReader(Env.QA).getMAX_NUMBER_OF_ATTEMPT();
	
	public static int currentAttempt=1;
	

	@Override
	public boolean retry(ITestResult result) {
		
		while(currentAttempt<=MAX_NUMBER_OF_ATTEMPT)
		{
			currentAttempt+=1;
			return true;
		}
		
		return false;
	}

}
