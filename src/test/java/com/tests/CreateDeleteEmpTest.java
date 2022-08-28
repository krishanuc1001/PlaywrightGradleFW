package com.tests;

import org.testng.annotations.Test;
import com.pages.HomePage;

public class CreateDeleteEmpTest extends BaseTest {

    @Test(priority = 1, enabled = false)
    public void createNewEmployeeTest() {
        new HomePage().clickEmpListBtn();
        new HomePage().clickCreateNew()
                .createEmployee("Krishanu", "20000", "5", "2", "abc@gmail.com");
    }

    @Test(priority = 2, enabled = false)
    public void deleteEmployeeTest() {
        new HomePage().clickEmpListBtn();
        new HomePage().deleteEmployee("Krishanu").clickDelBtn();
    }

    @Test(enabled = true)
    public void createDeleteEmpTest() {
        createNewEmployeeTest();
        deleteEmployeeTest();
    }


}
