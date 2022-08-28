package com.pages;

import base.BrowserIntialize;
import com.microsoft.playwright.Page;

public class DeleteEmpPage {

    private Page page = .localPage;

    private String deleteBtn = "//input[@value='Delete']";
    private String backToLst = "//a[normalize-space()='Back to List']";

    public HomePage clickDelBtn() {
        page.click(deleteBtn);
        return new HomePage();
    }

    public HomePage clickBackToList() {
        page.click(backToLst);
        return new HomePage();
    }

}
