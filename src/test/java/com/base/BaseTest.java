package com.base;

import com.factories.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.pages.HomePage;
import org.testng.annotations.*;

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

}
