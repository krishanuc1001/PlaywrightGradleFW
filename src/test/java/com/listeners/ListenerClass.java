package com.listeners;

import com.customAnnotations.FrameworkAnnotations;
import com.enums.CategoryTypeEnum;
import com.testUtilities.extentReporting.ExtentLogger;
import com.testUtilities.extentReporting.ExtentReport;
import com.utils.ELKUtils;
import org.testng.*;

import java.util.Arrays;

public class ListenerClass implements ITestListener, ISuiteListener {

	@Override
	public void onStart(ISuite suite) {
		ExtentReport.initReport();
	}

	@Override
	public void onFinish(ISuite suite) {
		ExtentReport.flushReport();
	}

	@Override
	public void onTestStart(ITestResult result) {
		ExtentReport.createTest(result.getMethod().getMethodName());

		String[] authors = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotations.class).author();

		ExtentReport.addAuthors(authors);

		CategoryTypeEnum[] categories = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(FrameworkAnnotations.class).category();

		ExtentReport.addCategory(categories);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " => PASSED");
		ELKUtils.sendDataToElasticSearch(result.getMethod().getMethodName(), "pass");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentLogger.fail(result.getMethod().getMethodName() + " => FAILED");
		ExtentLogger.fail(result.getThrowable().toString());
		ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		ELKUtils.sendDataToElasticSearch(result.getMethod().getMethodName(), "fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " => SKIPPED");
		ELKUtils.sendDataToElasticSearch(result.getMethod().getMethodName(), "skip");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		/*
		 * Not using this method now
		 * 
		 */
	}

	@Override
	public void onStart(ITestContext context) {
		/*
		 * Not using this method now
		 * 
		 */
	}

	@Override
	public void onFinish(ITestContext context) {
		/*
		 * Not using this method now
		 * 
		 */
	}

}
