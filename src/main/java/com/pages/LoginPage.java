package com.pages;

import com.microsoft.playwright.Page;

public class LoginPage {

    private Page page;

    public LoginPage(Page page) {
        this.page = page;
    }

    private String emailID = "#input-email";
    private String passWord = "//input[@id='input-password']";
    private String loginBtn = "xpath=//input[@value='Login']";
    private String forgotPwdLink = "//div[@class='form-group']//a[normalize-space()='Forgotten Password']";

    public AccountsPage doLogin(String email, String password) {
        page.fill(emailID, email);
        page.fill(passWord, password);
        page.click(loginBtn);
        return new AccountsPage(page);
    }

    public String getLoginPageTitle() {
        return page.title();
    }

    public boolean forgotPwdLinkPresent() {
        return page.isVisible(forgotPwdLink);
    }
}
