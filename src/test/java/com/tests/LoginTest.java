package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.HomePage;

public class LoginTest extends BaseTest {

    @Test(enabled = true)
    public void loginTest() {
        Assert.assertEquals(new HomePage().getHelloAdminTxt(), "Hello admin!");
    }

}
