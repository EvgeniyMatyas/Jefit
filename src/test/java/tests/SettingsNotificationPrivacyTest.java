package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;
import static pages.SettingsNotificationPrivacyPage.*;

public class SettingsNotificationPrivacyTest extends BaseTest {


    @Test(description = "Manage Notifications ")
    public void manageNotificationsTest() {
        loginPage
                .open()
                .loginWithValidData();
        boolean isNotificationsSettingsPageOpened = settingsNotificationPrivacyPage
                .openNotificationPrivacySettings()
                .editNotificationsReport()
                .isPageOpen();

        assertTrue(isNotificationsSettingsPageOpened, "Notifications Settings page hasn't opened");
        assertTrue(driver.findElement(NOTIFICATIONS_OPTION_CHECKED).isSelected(), "Notification radio-button isn't checked");

    }

    @Test(description = "Manage Privacy")
    public void managePrivacyTest() {
        loginPage
                .open()
                .loginWithValidData();
        boolean isPrivacySettingsPageOpened = settingsNotificationPrivacyPage
                .openNotificationPrivacySettings()
                .editPrivacySettings()
                .isPageOpen();

        assertTrue(isPrivacySettingsPageOpened, "Privacy Settings page hasn't opened");
        assertTrue(driver.findElement(PRIVACY_OPTION_CHECKED).isSelected(), "Privacy radio-button isn't checked");

    }
}
