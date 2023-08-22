package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;

public class MyJefitTest extends BaseTest {

    @Test(description = "Write a status")
    public void writeAStatus(){
        loginPage.loginWithValidData();
        myJefitPage.clickHomeButton()
                .writeStatus("My new Status")
                .clickPostButton()
                .pageRefresh();
        String text = myJefitPage.getStatusText();

        assertEquals(text, "My new Status", "Еhe file didn't load");

    }
}
