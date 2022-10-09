package com.pages;

import com.microsoft.playwright.Page;

public class HomePage {

    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    private String search = "xpath=//input[@name='search']";
    private String searchBtn = "div#search button";

    public String getHomePageTitle() {
        String homePageTitle = page.title();
        System.out.println(homePageTitle);
        return homePageTitle;
    }

    public String getHomePageURL() {
        String homePageURL = page.url();
        System.out.println(homePageURL);
        return homePageURL;
    }

    public SearchResultPage search(String productName) {
        page.fill(search, productName);
        page.click(searchBtn);
        return new SearchResultPage(page);
    }


}
