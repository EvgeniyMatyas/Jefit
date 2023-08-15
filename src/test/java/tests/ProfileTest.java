package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

public class ProfileTest extends BaseTest {

    @Test(description = "Checking profile fields with valid data")
    public void profileShouldBeCreated(){
        loginPage.open()
                .userNameOrEmailAndPassword("znoxezy@mailto.plus","123456789Ja*")
                .clickLogInButton()
                        .isPageOpen();
        profilePage.createProfile();
        myJefitPage.isPageOpen();


    }
}
