// TODO: 08.08.2023  
package tests;

import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import pages.SingUpPage;

public class SingUpTest extends BaseTest{

    @Test(description = "Registration of a user with valid data")
    @Description("Test descr")

    public void singUpUserWithValidData(){
        singUpPage.openJeFit();
        singUpPage.openSingUpPage();
        singUpPage.inputValidationData("Dudidoda","saczany@mailto.plus","123456789Az*","123456789Az*");
        singUpPage.clickRecaptchaButton();
        singUpPage.clickAccountButton();


    }




}
