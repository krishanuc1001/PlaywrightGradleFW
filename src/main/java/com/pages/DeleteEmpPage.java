package com.pages;

import com.microsoft.playwright.Page;

public class DeleteEmpPage {

    private Page page;

    private String deleteBtn = "//input[@value='Delete']";
    private String backToLst = "//a[normalize-space()='Back to List']";

    public HomePageOld clickDelBtn() {
        page.click(deleteBtn);
        return new HomePageOld();
    }

    public HomePageOld clickBackToList() {
        page.click(backToLst);
        return new HomePageOld();
    }

}
