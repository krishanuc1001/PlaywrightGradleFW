package com.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.enums.ConfigPropertiesEnum;
import com.utils.PropertiesUtils;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }

    private static final String PATHTORESOURCES = System.getProperty("user.dir") + "/src/test/resources";

    private static final String CONFIGPROPPATH = PATHTORESOURCES + "/config/config.properties";
    private static final String CONFIGJSONPATH = PATHTORESOURCES + "/jsons/config.json";
    private static final String EXCELPATH = System.getProperty("user.dir") + "/excel/SampleTestDataWorkbook.xlsx";
    private static final String EXTENTREPORFOLDERTPATH = System.getProperty("user.dir") + "/ExtentReport-output/";
    private static final String RUNMANAGERSHEET = "RUNMANAGER";
    private static final String DATASHEET = "DATA";

    private static String extentReportFilePath = "";

    // private static final int EXPLICITLYWAITTIME = 30;

    public static String getExtentReportFilePath() {
        if (extentReportFilePath.isEmpty()) {
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    public static String createReportPath() {
        if (PropertiesUtils.get(ConfigPropertiesEnum.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORFOLDERTPATH + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date()) + "/"
                    + new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss").format(new Date()) + "_ExtentReport.html";
        } else {
            return EXTENTREPORFOLDERTPATH + "/" + "ExtentReport.html";
        }
    }

//    public static String getChromedriverpath() {
//        return CHROMEDRIVERPATH;
//    }
//
//    public static String getFirefoxdriverpath() {
//        return GECKODRIVERPATH;
//    }

    public static String getConfigproppath() {
        return CONFIGPROPPATH;
    }

//    public static int getExplicityWaitTime() {
//        return EXPLICITLYWAITTIME;
//    }

    public static String getConfigjsonpath() {
        return CONFIGJSONPATH;
    }

    public static String getExcelpath() {
        return EXCELPATH;
    }

    public static String getRunmanagersheet() {
        return RUNMANAGERSHEET;
    }

    public static String getDatasheet() {
        return DATASHEET;
    }

}
