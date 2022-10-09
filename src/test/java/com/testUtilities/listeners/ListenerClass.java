package com.testUtilities.listeners;

import com.testUtilities.extentReporting.ExtentLogger;
import com.testUtilities.extentReporting.ExtentReport;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.*;

import java.util.Arrays;
import java.util.Map;

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
        if((Arrays.stream(result.getMethod().getGroups()).anyMatch("e2eTests"::equalsIgnoreCase))||(Arrays.stream(result.getMethod().getGroups()).anyMatch("e2eSanity"::equalsIgnoreCase)))
        {
           Map<String,String> data = (Map) result.getParameters()[0];

           ExtentReport.createTest(data.get("TestDescription"));
        }

        else
            ExtentReport.createTest(result.getMethod().getMethodName());

//		String[] authors = result.getMethod().getConstructorOrMethod().getMethod()
//				.getAnnotation(FrameworkAnnotations.class).author();

//		ExtentReport.addAuthors(authors);
//
//		CategoryTypeEnum[] categories = result.getMethod().getConstructorOrMethod().getMethod()
//				.getAnnotation(FrameworkAnnotations.class).category();

//      ExtentReport.addCategory(categories);

    }

//    @Override
//    public void onTestSuccess(ITestResult result) {
//        ExtentLogger.pass(result.getMethod().getMethodName() + " => PASSED", true);
//        // ELKUtils.sendDataToElasticSearch(result.getMethod().getMethodName(), "pass");
//    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        ExtentLogger.fail(result.getMethod().getMethodName() + " => FAILED", true);
//        ExtentLogger.fail(ExceptionUtils.getStackTrace(result.getThrowable()));
//        // ELKUtils.sendDataToElasticSearch(result.getMethod().getMethodName(), "fail");
//    }

//    @Override
//    public void onTestSkipped(ITestResult result) {
//        ExtentLogger.skip(result.getMethod().getMethodName() + " => SKIPPED", true);
//        ExtentLogger.skip(ExceptionUtils.getStackTrace(result.getThrowable()));
//        // ELKUtils.sendDataToElasticSearch(result.getMethod().getMethodName(), "skip");
//    }

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
