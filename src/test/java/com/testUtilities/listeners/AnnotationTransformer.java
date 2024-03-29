package com.testUtilities.listeners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer {

  @Override
  public void transform(
      ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

    // annotation.setDataProvider("getData");
    // annotation.setDataProviderClass(DataProviderUtils.class);
    annotation.setRetryAnalyzer((Class<? extends IRetryAnalyzer>) RetryFailedTests.class);
  }
}
