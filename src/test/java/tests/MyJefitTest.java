package tests;


import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class MyJefitTest extends BaseTest {

    @Test(description = "Write a status")
    public void writeAStatus(){
        loginPage.loginWithValidData()
                 .clickHomeButton()
                 .writeStatus("My new Status")
                 .clickPostButton()
                 .pageRefresh();
        String actualStatus = myJefitPage.getStatusText();

        assertEquals(actualStatus, "My new Status", "Еhe file didn't load");

    }

    @Test(description = "Open Body Stats nav-tab: Body Stats")
    public void openBodyStats() {
        loginPage.loginWithValidData()
                 .clickBodyStatsButton();

        assertTrue(myJefitPage.isBodyStatusOpen(), "The navigation tab did not open");

    }

    @Test(description = "Open Body Stats nav-tab: Training Stats")
    public void openTrainingStats() {
        loginPage.loginWithValidData()
                 .clickTrainingStatsButton();

        assertTrue(myJefitPage.isTrainingStatsOpen(), "The navigation tab did not open");

    }

    @Test(description = "Open Body Stats nav-tab: Progress Photos")
    public void openProgressPhotos() {
        loginPage.loginWithValidData()
                 .clickProgressPhotosButton();

        assertTrue(myJefitPage.isProgressPhotosOpen(), "The navigation tab did not open");

    }


}
