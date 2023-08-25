package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import static org.testng.Assert.*;
public class LoginTest extends BaseTest {
    @Test(description = "Login verification with valid data")
    public void loginUserIsValidData(){
        boolean isProfilePageOpen = loginPage.open()
                .userNameAndPassword("yxobx@mailto.plus","123456789Ja*")
                .clickLogInButton()
                .isPageOpen();
        assertTrue(isProfilePageOpen);
    }

    @DataProvider(name = "incorrectLoginTest")
    public Object[][] incorrectLoginTest(){
            return new Object[][]{
                    {"", "", "Invalid username/email or password"},
                    {"sdfdsf#jhjhg", "", "Invalid username/email or password"},
                    {"", "34534gfv546", "Invalid username/email or password"},
                    {"Hgfjghkjghkgh", "45654gjghj", "Invalid username/email or password"},
            };

    }
    @Test(dataProvider = "incorrectLoginTest")
    public void loginTestWithWrongData(String login,String password,String errorMessage){
        loginPage.open()
                .userNameAndPassword(login,password)
                .clickLogInButton();
        assertEquals(loginPage.getErrorMessage(), errorMessage,
                "The message text is incorrect or missing");

}
}
