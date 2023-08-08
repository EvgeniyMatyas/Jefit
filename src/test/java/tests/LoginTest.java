package tests;

import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import jdk.jfr.Description;
import org.testng.annotations.Test;

import static org.testng.Assert.*;
public class LoginTest extends BaseTest{
    @Test(description = "Login verification with valid data")
    @Description("Test descr")
    @Issue("B1234")
    @TmsLink("case123j")
    public void loginUserIsValidData(){
        boolean isProfilePageOpen = loginPage.open()
                .ValidUserNameOrEmailAndPassword("Jamezzusz@mail.ru","77721185948934James*")
                .clickLogInButton()
                .isPageOpen();
        assertTrue(isProfilePageOpen);
    }

}
