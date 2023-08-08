package tests;

import org.testng.annotations.Test;

public class ProfileTest extends BaseTest{

    @Test(description = "Checking profile fields with valid data")
    public void profileShouldBeCreated(){
        loginPage.open()
                .ValidUserNameOrEmailAndPassword("Jamezzusz@mail.ru","77721185948934James*")
                .clickLogInButton();
        profilePage.createProfile()
                .clickCreateProfileButton();
    }
}
