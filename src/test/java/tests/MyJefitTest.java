package tests;


import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyJefitTest extends BaseTest {

    @Test(description = "Write a status")
    public void writeAStatus(){
        loginPage
                .open()
                .loginWithValidData()
                .clickHomeButton()
                .writeStatus()
                .clickPostButton()
                .pageRefresh();
        String actualStatus = myJefitPage.getStatusText();

        assertEquals(actualStatus, "My new status", "Еhe file didn't load");

    }



}
