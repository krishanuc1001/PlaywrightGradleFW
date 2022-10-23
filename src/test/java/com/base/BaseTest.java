package com.base;

import com.constants.FrameworkConstants;
import com.factories.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.pages.HomePage;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {

    PlaywrightFactory playwrightFactory;
    protected Page page;
    protected Properties properties;

    protected HomePage homePage;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void setUp(String browserName) {
        playwrightFactory = new PlaywrightFactory();
        properties = playwrightFactory.initProperties();

        if (browserName != null) {
            properties.setProperty("browser", browserName);
        }

        page = playwrightFactory.initBrowser(properties);
        homePage = new HomePage(page);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        page.context().browser().close();
    }

    @AfterSuite(alwaysRun = true)
    public void cleanDir() throws IOException {
        System.out.println("<<============ CLEANING SCREENSHOT DIRECTORY ============>>");
        if (!FrameworkConstants.getScreenshotFolderPath().isEmpty()) {
            FileUtils.cleanDirectory(new File(FrameworkConstants.getScreenshotFolderPath()));
        } else {
            System.out.println("<<============ NO SCREENSHOTS TO CLEAN ============>>");
        }
    }

}
