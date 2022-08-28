package com.pages;

import base.BrowserIntialize;
import com.microsoft.playwright.Page;

public class HomePage {

    private Page page = .localPage;
    // private Page page;

//    public HomePage(Page page) {
//        FrameworkConfig.localPage = page;
//    }

    private String employeeList = "text='Employee List'";
    private String createNewBtn = "text='Create New'";
    private String logOff = "text='Log off'";
    private String searchBtn = "//input[@type='submit']";
    private String helloAdmin = "//a[text()='Hello admin!']";


    public void clickEmpListBtn() {
        page.click(employeeList);
    }

    public CreateEmployeePage clickCreateNew() {
        page.click(createNewBtn);
        return new CreateEmployeePage();
    }

    public DeleteEmpPage deleteEmployee(String empName) {

        //td[normalize-space()='Krishanu']/parent::tr//td//a[text()='Delete']
        String deleteEmployeeBtn = "//td[normalize-space()='" + empName + "']/parent::tr//td//a[text()='Delete']";
        page.click(deleteEmployeeBtn);

        return new DeleteEmpPage();

    }

    public void clickLogOffBtn() {
        page.click(logOff);
    }

    public void clickSearchBtn() {
        page.click(searchBtn);
    }

    public String getHelloAdminTxt() {
        return page.textContent(helloAdmin);
    }

}