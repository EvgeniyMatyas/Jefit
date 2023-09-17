package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;

public class ProfilePicTest extends BaseTest {

    @Test
    public void uploadPicture() {
        loginPage
                .open()
                .loginWithValidData();
        profilepicPage
                .open()
                .uploadFile();

        String src = profilepicPage.fileIsUploaded();
        assertTrue(src.contains("avatar"), "Picture not uploaded");
    }
}
