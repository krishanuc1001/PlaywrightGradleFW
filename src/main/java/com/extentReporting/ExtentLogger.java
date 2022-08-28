package com.extentReporting;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.enums.ConfigPropertiesEnum;
import com.utils.PropertiesUtils;
import com.utils.ScreenshotUtils;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	public static void pass(String message) {
		ExtentManager.getExtentDriver().pass(message);
	}

//	public static void pass(String message, boolean isScreenshotNeeded) {
//
//		if (PropertiesUtils.get(ConfigPropertiesEnum.PASSEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
//				&& isScreenshotNeeded) {
//
//			ExtentManager.getExtentDriver().pass(message,
//					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
//		} else {
//			pass(message);
//		}
//
//	}

	public static void fail(String message) {
		ExtentManager.getExtentDriver().fail(message);
	}

//	public static void fail(String message, boolean isScreenshotNeeded) {
//
//		if (PropertiesUtils.get(ConfigPropertiesEnum.FAILEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
//				&& isScreenshotNeeded) {
//
//			ExtentManager.getExtentDriver().fail(message,
//					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
//
//		} else {
//			fail(message);
//		}
//	}

	public static void skip(String message) {
		ExtentManager.getExtentDriver().skip(message);
	}

//	public static void skip(String message, boolean isScreenshotNeeded) {
//
//		if (PropertiesUtils.get(ConfigPropertiesEnum.SKIPPEDSTEPSSCREENSHOTS).equalsIgnoreCase("yes")
//				&& isScreenshotNeeded) {
//
//			ExtentManager.getExtentDriver().skip(message,
//					MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenshotUtils.getBase64Image()).build());
//
//		} else {
//			skip(message);
//		}
//	}

}
