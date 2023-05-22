package com.testUtilities.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTests implements IRetryAnalyzer {

  private int counter = 0;
  private int retryNum = 2;

  @Override
  public boolean retry(ITestResult result) {

    boolean value = false;

    try {
      //            if (ReadProperties.get("retryfailedtests").equalsIgnoreCase("yes")) {
      //                value = counter < retryNum;
      //                counter++;
      //            }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return value;
  }
}
