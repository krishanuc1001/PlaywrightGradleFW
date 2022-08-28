package com.pages;

import base.FrameworkInitialize;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;

public class LoginPage extends FrameworkInitialize{

    private Page page = new FrameworkInitialize().getPage(new FrameworkInitialize().getBrowserContext());
    // private Page page;

//    public LoginPage(Page page) {
//        this.page = page;
//    }

    private String userName = "//input[@id='UserName']";
    private String passWord = "//input[@id='Password']";
    private String loginBtnHomePage = "//a[text()='Login']";
    private String loginBtnLoginPage = "//input[@value='Log in']";

    public HomePage login(String username, String password) {
        page.click(loginBtnHomePage);
        page.fill(userName, username);
        page.fill(passWord, password);
        page.click(loginBtnLoginPage);

        return new HomePage();
    }

}
