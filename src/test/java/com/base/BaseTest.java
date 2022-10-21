package com.base;

import com.factories.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.pages.HomePage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory playwrightFactory;
    protected Page page;
    protected Properties properties;

    protected HomePage homePage;

    @Parameters({"browser"})
    @BeforeTest
    public void setUp(String browserName) {
        playwrightFactory = new PlaywrightFactory();
        properties = playwrightFactory.initProperties();

        if (browserName != null) {
            properties.setProperty("browser", browserName);
        }

        page = playwrightFactory.initBrowser(properties);
        homePage = new HomePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }

}
