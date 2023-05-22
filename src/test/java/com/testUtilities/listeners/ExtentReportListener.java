package com.testUtilities.listeners;

import static com.utils.ScreenshotUtils.takeScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.constants.FrameworkConstants;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener, ISuiteListener {

  static String extentReportFolderPath = FrameworkConstants.getExtentReportFolderPath();
  static String extentReportFilePath = FrameworkConstants.getExtentReportFilePath();

  private static ExtentReports extentReports = init();
  public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

  private static ExtentReports init() {

    Path path = Paths.get(extentReportFolderPath);

    if (!Files.exists(path)) {
      try {
        Files.createDirectories(path);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    extentReports = new ExtentReports();
    ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportFilePath);
    reporter.config().setReportName("PLAYWRIGHT TEST AUTOMATION EXECUTION");
    extentReports.attachReporter(reporter);
    extentReports.setSystemInfo("System", "Macbook Pro");
    extentReports.setSystemInfo("Author", "Krishanu");

    return extentReports;
  }

  @Override
  public synchronized void onStart(ISuite suite) {
    System.out.println("<<============ TEST SUITE EXECUTION STARTED ==============>>");
  }

  @Override
  public synchronized void onFinish(ISuite suite) {
    flushReport();
    System.out.println("<<============ TEST SUITE EXECUTION FINISHED ==============>>");
  }

  @Override
  public synchronized void onTestStart(ITestResult result) {
    String methodName = result.getMethod().getMethodName();
    String qualifiedName = result.getMethod().getQualifiedName();
    int last = qualifiedName.lastIndexOf(".");
    int mid = qualifiedName.substring(0, last).lastIndexOf(".");
    String className = qualifiedName.substring(mid + 1, last);

    System.out.println(methodName + " started!");
    ExtentTest test =
        extentReports.createTest(
            result.getMethod().getMethodName(), result.getMethod().getDescription());

    test.assignCategory(result.getTestContext().getSuite().getName());
    test.assignCategory(className);
    extentTest.set(test);
    extentTest.get().getModel().setStartTime(getTime(result.getStartMillis()));
  }

  public synchronized void onTestSuccess(ITestResult result) {
    System.out.println((result.getMethod().getMethodName() + " ======> passed"));
    extentTest.get().pass(result.getMethod().getMethodName() + " ======> passed");
    extentTest
        .get()
        .pass(
            result.getThrowable(),
            MediaEntityBuilder.createScreenCaptureFromBase64String(
                    takeScreenshot(), result.getMethod().getMethodName())
                .build());
    extentTest.get().getModel().setEndTime(getTime(result.getEndMillis()));
  }

  public synchronized void onTestFailure(ITestResult result) {
    System.out.println((result.getMethod().getMethodName() + " ======> failed"));
    extentTest.get().fail(result.getMethod().getMethodName() + " ======> failed");
    extentTest
        .get()
        .fail(
            ExceptionUtils.getStackTrace(result.getThrowable()).replaceAll("\n", "<br />"),
            MediaEntityBuilder.createScreenCaptureFromBase64String(
                    takeScreenshot(), result.getMethod().getMethodName())
                .build());
    extentTest.get().getModel().setEndTime(getTime(result.getEndMillis()));
  }

  public synchronized void onTestSkipped(ITestResult result) {
    System.out.println((result.getMethod().getMethodName() + " ======> skipped"));
    extentTest.get().skip(result.getMethod().getMethodName() + " ======> skipped");
    extentTest
        .get()
        .skip(
            ExceptionUtils.getStackTrace(result.getThrowable()).replaceAll("\n", "<br />"),
            MediaEntityBuilder.createScreenCaptureFromBase64String(
                    takeScreenshot(), result.getMethod().getMethodName())
                .build());
    extentTest.get().getModel().setEndTime(getTime(result.getEndMillis()));
  }

  public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    System.out.println(
        ("onTestFailedButWithinSuccessPercentage for " + result.getMethod().getMethodName()));
  }

  private Date getTime(long millis) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(millis);
    return calendar.getTime();
  }

  public static void flushReport() {
    if (Objects.nonNull(extentReports)) {
      extentReports.flush();
      extentTest.remove();

      if (Desktop.isDesktopSupported()) {
        try {
          Desktop.getDesktop().browse(new File(extentReportFilePath).toURI());
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
