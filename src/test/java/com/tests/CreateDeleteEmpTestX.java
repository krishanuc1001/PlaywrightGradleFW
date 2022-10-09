package com.tests;

import com.pages.HomePageOld;
import org.testng.annotations.Test;

public class CreateDeleteEmpTestX extends BaseTestX {

    @Test(priority = 1, enabled = false)
    public void createNewEmployeeTest() {
        new HomePageOld().clickEmpListBtn();
        new HomePageOld().clickCreateNew()
                .createEmployee("Krishanu", "20000", "5", "2", "abc@gmail.com");
    }

    @Test(priority = 2, enabled = false)
    public void deleteEmployeeTest() {
        new HomePageOld().clickEmpListBtn();
        new HomePageOld().deleteEmployee("Krishanu").clickDelBtn();
    }

    @Test(enabled = true)
    public void createDeleteEmpTest() {
        createNewEmployeeTest();
        deleteEmployeeTest();
    }


}
