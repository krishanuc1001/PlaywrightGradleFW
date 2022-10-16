package com.tests;

import com.base.BaseTest;
import com.constants.FrameworkConstants;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Slf4j
@Test(groups = {"homePageTests", "pageTests"})
public class HomePageTest extends BaseTest {

    @Test(priority = 1)
    public void validateHomePageTitle() {
        String actualHomePageTitle = homePage.getHomePageTitle();
        String expectedHomePageTitle = FrameworkConstants.getActualHomePageTitle();
        Assert.assertEquals(actualHomePageTitle, expectedHomePageTitle,
                "<<============= The actual and expected Home page titles do not match ===========>>");
    }

    @Test(priority = 2)
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


    @Test(priority = 3, dataProvider = "getData")
    public void validateSearchFunctionality(String productName) {
        Assert.assertEquals(homePage.search(productName).getSearchPageHeader(), "Search - " + productName,
                "<<============= The actual and expected Search page headers do not match ===========>>");
    }

}
