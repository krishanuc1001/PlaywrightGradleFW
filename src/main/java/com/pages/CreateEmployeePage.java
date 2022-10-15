package com.pages;

import com.microsoft.playwright.Page;

public class CreateEmployeePage {

    private Page page;
    // private Page page;

//    public CreateEmployeePage(Page page) {
//        FrameworkConfig.localPage = page;
//    }

    private String nameField = "//input[@id='Name']";
    private String salaryField = "//input[@id='Salary']";
    private String durationWorkedField = "//input[@id='DurationWorked']";
    private String gradeField = "//input[@id='Grade']";
    private String emailField = "//input[@id='Email']";
    private String createBtn = "//input[@value='Create']";

    public HomePageOld createEmployee(String name, String salary, String duration, String grade, String email) {
        page.fill(nameField, name);
        page.fill(salaryField, salary);
        page.fill(durationWorkedField, duration);
        page.fill(gradeField, grade);
        page.fill(emailField, email);

        page.click(createBtn);

        return new HomePageOld();
    }

}
