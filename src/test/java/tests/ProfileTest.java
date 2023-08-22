package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProfileTest extends BaseTest {

    @Test(description = "Checking profile fields with valid data")
    public void profileShouldBeCreated(){
        loginPage.loginWithValidData();
        profilePage.createProfile();
        myJefitPage.isPageOpen();


    }
}
