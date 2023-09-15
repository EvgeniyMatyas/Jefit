package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class ProfilEpicTest extends BaseTest {

    @Test
    public void uploadPicture() {
        loginPage.loginWithValidData();
        profilepicPage
                .open()
                .uploadFile();
        myJefitPage.open();
        String text = myJefitPage.getTextPictureUploaded();
        assertEquals(text, "Has posted a new profile picture.", "Еhe file didn't load");
    }
}
