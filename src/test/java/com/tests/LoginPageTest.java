package com.tests;

import com.base.BaseTest;
import com.constants.FrameworkConstants;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @Test(priority = 1)
    public void validateLoginPageTitle() {
        String actualLoginPageTitle = homePage.navigateToLoginPage().getLoginPageTitle();
        String expectedLoginPageTitle = FrameworkConstants.getActualLoginPageTitle();
        Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle,
                "<<============= The actual and expected Login page titles do not match ===========>>");
    }

    @Test(priority = 2)
    public void validateForgotPwdLink() {
        Assert.assertTrue(homePage.navigateToLoginPage().forgotPwdLinkPresent());
    }

    @Test(priority = 3)
    public void validateLogin() {
        Assert.assertTrue(homePage
                .navigateToLoginPage()
                .doLogin(properties.getProperty("email").trim(), properties.getProperty("password").trim())
                .checkLogin());
    }

}
