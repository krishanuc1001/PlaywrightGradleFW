package com.pages;

import com.microsoft.playwright.Page;

public class LoginPageOld {

    // private Page page = new FrameworkInitialize().getPage(new FrameworkInitialize().getBrowserContext());
    private Page page;

//    public LoginPageOld(Page page) {
//        this.page = page;
//    }

    private String userName = "//input[@id='UserName']";
    private String passWord = "//input[@id='Password']";
    private String loginBtnHomePage = "//a[text()='Login']";
    private String loginBtnLoginPage = "//input[@value='Log in']";

    public HomePageOld login(String username, String password) {
        page.click(loginBtnHomePage);
        page.fill(userName, username);
        page.fill(passWord, password);
        page.click(loginBtnLoginPage);

        return new HomePageOld();
    }

}
