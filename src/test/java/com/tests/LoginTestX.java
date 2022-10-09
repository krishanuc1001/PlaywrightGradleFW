package com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.pages.HomePageOld;

public class LoginTestX extends BaseTestX {

    @Test(enabled = true)
    public void loginTest() {
        Assert.assertEquals(new HomePageOld().getHelloAdminTxt(), "Hello admin!");
    }

}
