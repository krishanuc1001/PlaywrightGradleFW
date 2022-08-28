package com.listeners;

import com.enums.ConfigPropertiesEnum;
import com.utils.PropertiesUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

	private int counter = 0;
	private int retryNum = 1;

	@Override
	public boolean retry(ITestResult result) {

		boolean value = false;

		if (PropertiesUtils.get(ConfigPropertiesEnum.RETRYFAILEDTESTS).equalsIgnoreCase("yes")) {
			value = counter < retryNum;
			counter++;
		}

		return value;

	}

}
