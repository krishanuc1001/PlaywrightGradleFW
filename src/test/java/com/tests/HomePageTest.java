package com.tests;

import com.base.BaseTest;
import com.constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void validateHomePageTitle() {
        String actualHomePageTitle = homePage.getHomePageTitle();
        String expectedHomePageTitle = FrameworkConstants.getActualHomePageTitle();
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle,
                "<<============= The actual and expected Home page titles do not match ===========>>");
    }

    @Test
    public void validateHomePageURL() {
        Assert.assertEquals(homePage.getHomePageURL(), properties.getProperty("url"),
                "<<============= The actual and expected Home page URLs do not match ===========>>");
    }

    @DataProvider
    public Object[][] getData() {
        return new Object[][]{
                {"Samsung"},
                {"Macbook Pro"},
                {"Oneplus"}
        };
    }


    @Test(dataProvider = "getData")
    public void validateSearchFunctionality(String productName) {
        Assert.assertEquals(homePage.search(productName).getSearchPageHeader(), "Search - " + productName,
                "<<============= The actual and expected Search page headers do not match ===========>>");
    }

}
