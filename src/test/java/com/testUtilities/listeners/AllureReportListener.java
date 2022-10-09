package com.testUtilities.listeners;

import io.qameta.allure.Allure;
import io.qameta.allure.AllureLifecycle;
import io.qameta.allure.Attachment;
import io.qameta.allure.model.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Map;


public class AllureReportListener implements ITestListener {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG (WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

//    @Override
//    public void onStart(ITestContext iTestContext) {
//        System.out.println("Starting Test Suite '" + iTestContext.getName() + "'.......");
//        WebDriver driver = DriverManager.getDr();
//        iTestContext.setAttribute("WebDriver", driver);
//    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("Finished Test Suite '" + iTestContext.getName() + "'");
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("Starting Test Method '" + getTestMethodName(iTestResult) + "'");
        if((Arrays.stream(iTestResult.getMethod().getGroups()).anyMatch("e2eTests"::equalsIgnoreCase))||(Arrays.stream(iTestResult.getMethod().getGroups()).anyMatch("e2eSanity"::equalsIgnoreCase)))
        {
            Map<String,String> data = (Map) iTestResult.getParameters()[0];
            AllureLifecycle lifecycle = Allure.getLifecycle();
            lifecycle.updateTestCase(testResult -> testResult.setName(data.get("TestDescription")));
            lifecycle.updateTestCase(testResult -> testResult.setDescription(data.get("TestDescription")));
        }
    }

//    @Override
//    public void onTestSuccess(ITestResult iTestResult) {
//        System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' is Passed");
//        WebDriver driver = DriverManager.getDr();
//        System.out.println("Screenshot has captured for the Test Method '" + getTestMethodName(iTestResult) + "'");
//        Allure.addAttachment(getTestMethodName(iTestResult), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//        Allure.step(getTestMethodName(iTestResult), Status.PASSED);
//    }

//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' is Failed");
//        WebDriver driver = DriverManager.getDr();
//        if (driver != null) {
//            System.out.println("Screenshot has captured for the Test Method '" + getTestMethodName(iTestResult) + "'");
//            Allure.addAttachment(iTestResult.getThrowable().getMessage(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
//            Allure.step(getTestMethodName(iTestResult), Status.FAILED);
//        }
//    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("Test Method '" + getTestMethodName(iTestResult) + "' is Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
}
