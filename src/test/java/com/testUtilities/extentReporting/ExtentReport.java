package com.testUtilities.extentReporting;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.constants.FrameworkConstants;
import com.enums.CategoryTypeEnum;

public final class ExtentReport {

	private ExtentReport() {
	}

	private static ExtentReports extent;
	private static ExtentSparkReporter spark;

	public static void initReport() {

		if (Objects.isNull(extent)) {
			extent = new ExtentReports();
			spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.DARK);
			spark.config().setDocumentTitle("Extent Automation Report");
			spark.config().setReportName("Test Extent Report");
		}

	}

	public static void createTest(String testCaseName) {
		ExtentTest test = extent.createTest(testCaseName);
		ExtentManager.setExtentDriver(test);
	}

	public static void flushReport() {

		if (Objects.nonNull(extent)) {
			extent.flush();
			ExtentManager.removeExtentDriver();

			if (Desktop.isDesktopSupported()) {
				try {
					// Opens the report file in the desktop default browser
					Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

	}

	public static void addAuthors(String[] authors) {
		for (String str : authors) {
			ExtentManager.getExtentDriver().assignAuthor(str);
		}
	}

	public static void addCategory(CategoryTypeEnum[] categories) {
		for (CategoryTypeEnum str : categories) {
			ExtentManager.getExtentDriver().assignCategory(str.toString());
		}
	}

}
