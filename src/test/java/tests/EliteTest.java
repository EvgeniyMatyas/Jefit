package tests;

import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.assertTrue;

public class EliteTest extends BaseTest {

    @Test(description = "Open Get Elite page")
    public void openGetElitePage() {
        loginPage
                .open()
                .loginWithValidData();
        boolean isGetElitePageOpened = elitePage
                .openElitePage()
                .isPageOpen();

        assertTrue(isGetElitePageOpened, "Get Elite page hasn't opened");

    }

}
