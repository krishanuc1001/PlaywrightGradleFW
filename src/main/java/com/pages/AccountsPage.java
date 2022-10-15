package com.pages;

import com.microsoft.playwright.Page;

public class AccountsPage {

    private Page page;

    public AccountsPage(Page page) {
        this.page = page;
    }

    private String logOutLink = "//a[@class='list-group-item'][normalize-space()='Logout']";

    public boolean checkLogin() {
        return page.isVisible(logOutLink);
    }


}
