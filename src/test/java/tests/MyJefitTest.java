package tests;


import models.Status;
import models.StatusFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyJefitTest extends BaseTest {

    @Test(description = "Write a status")
    public void writeAStatus(){
        loginPage
                .open()
                .loginWithValidData();

        Status status = StatusFactory.get();

        myJefitPage.writingTheStatus(status);

        assertEquals(myJefitPage.getStatusText(), myJefitPage.returnFakerText(), "Еhe file didn't load");

    }



}
