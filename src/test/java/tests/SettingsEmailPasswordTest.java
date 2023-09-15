package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class SettingsEmailPasswordTest extends BaseTest {


    @Test(description = "Open Email Password Settings page")
    public void emailPasswordSettingsShouldBeOpenedTest() {
        loginPage
                .open()
                .loginWithValidData();
        boolean isEmailPasswordSettingsPageOpened = settingsEmailPasswordPage
                .openEmailPasswordSettings()
                .isPageOpen();

        assertTrue(isEmailPasswordSettingsPageOpened, "Email / Password Settings page hasn't opened");

    }

}
