package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SettingsMembershipTest extends BaseTest {

    @Test(description = "Open Member Ship Settings page")
    public void memberShipSettingsShouldBeOpenedTest() {
        loginPage
                .open()
                .loginWithValidData();
        boolean isMembershipSettingsPageOpened = settingsMembershipPage
                .openMembershipSettings()
                .isPageOpen();

        assertTrue(isMembershipSettingsPageOpened, "Membership Settings page hasn't opened");
        assertEquals(settingsMembershipPage.getAccountType(), "Account Type : Regular", "Type of account doesn't match");
    }
}
