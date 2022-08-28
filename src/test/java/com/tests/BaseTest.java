package com.tests;

import base.BrowserIntialize;
import base.FrameworkInitialize;
import com.pages.HomePage;
import com.pages.LoginPage;
import config.TestSettings;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void setUp() {
        BrowserIntialize.localPage = new FrameworkInitialize().initializePlaywright();
        // FrameworkConfig.localPage.navigate("https://www.johndeerestore.com/jdb2cstorefront/JohnDeereStore/en/");
        BrowserIntialize.localPage.navigate(TestSettings.url);
        new LoginPage(page).login("admin", "password");
    }


    @AfterTest(enabled = true)
    public void tearDown() {
        BrowserIntialize.localPage.close();
        BrowserIntialize.browser.close();
        BrowserIntialize.playwright.close();
    }

    @AfterSuite
    public void logOff() {
        new HomePage().clickLogOffBtn();
    }

}
