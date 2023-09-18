package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;


public class SettingsProfileAppTest extends BaseTest {

    @Test(description = "Open Profile Settings App")
    public void openProfileSettingsApp() {
        loginPage
                .open()
                .loginWithValidData();
        boolean isSettingsPageOpened = settingsProfileAppPage
                .openProfileAppSettings()
                .isPageOpen();

        assertTrue(isSettingsPageOpened, "Profile App Settings page hasn't opened");

    }

    @Test(description = "Edit data of birth")
    public void editDataOfBirth() {
        loginPage
                .open()
                .loginWithValidData();
        boolean isSettingsPageOpened = settingsProfileAppPage
                .openProfileAppSettings()
                .isPageOpen();

        assertTrue(isSettingsPageOpened, "Profile App Settings page hasn't opened");

        boolean isSavedSettingsPageOpened = settingsProfileAppPage
                .editDataOfBirth()
                .saveDataOfBirth()
                .isPageOpen();

        assertTrue(isSavedSettingsPageOpened, "Profile App Settings page hasn't opened");
        assertEquals(settingsProfileAppPage.getSavedMonthOfBirth(),settingsProfileAppPage.getNewMonthOfBirth(), "Month of birth doesn't match");
        assertEquals(settingsProfileAppPage.getSavedDateOfBirth(),settingsProfileAppPage.getNewDateOfBirth(), "Date of birth doesn't match");
        assertEquals(settingsProfileAppPage.getSavedYearOfBirth(),settingsProfileAppPage.getNewYearOfBirth(), "Year of birth doesn't match");

    }

}