package com.tests;

import com.factories.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest {

    PlaywrightFactory playwrightFactory;
    Page page;
    HomePage homePage;
    String productName = "iPhone";

    @BeforeTest
    public void setUp() {
        playwrightFactory = new PlaywrightFactory();
        page = playwrightFactory.initBrowser("chrome");
        homePage = new HomePage(page);
    }

    @Test
    public void validateHomePageTitle() {
        String actualHomePageTitle = homePage.getHomePageTitle();
        String expectedHomePageTitle = "Your Store";
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle,
                "<<============= The actual and expected Home page titles do not match ===========>>");
    }

    @Test
    public void validateHomePageURL() {
        Assert.assertEquals(homePage.getHomePageURL(), "https://naveenautomationlabs.com/opencart/",
                "<<============= The actual and expected Home page URLs do not match ===========>>");
    }

    @Test
    public void validateSearchFunctionality() {
        Assert.assertEquals(homePage.search(productName).getSearchPageHeader(), "Search - " + productName,
                "<<============= The actual and expected Search page headers do not match ===========>>");
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }


}
