package tests;

import models.AboutMe;
import models.AboutMeFactory;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AboutMeTest extends BaseTest {
    @Test(description = "Create About Me")
    public void aboutMeCreate() {
        loginPage.open()
                .loginWithValidData();

        AboutMe aboutMe = AboutMeFactory.get();

        aboutMePage.open()
                .create(aboutMe);

        boolean isUserPageOpened = userPage
                .open()
                .isPageOpen();

        assertTrue(isUserPageOpened, "User page hasn't opened");
        //TODO assert

    }
}
