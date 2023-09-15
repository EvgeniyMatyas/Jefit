package pages;

import elements.Input;
import elements.Button;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage{

    public static final By LOG_IN_TITTLE = By.id("signuplogintitle");
    public static final By ERROR_MESSAGE = By.id("invalidpassworderrormessage");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening the Login page")
    public LoginPage open(){
        driver.get(BASE_URL + "login");
        log.info("Open Login page with URL: "+ BASE_URL+"login");
        return this;
    }

    @Step("Enter Username or Email: '{name}' and Password: '{password}'")
    public LoginPage userNameAndPassword(String email,String password) {
        new Input(driver, "vb_login_username").write(email);
        log.info("Input the USERNAME or EMAIL in the field: " + email);
        new Input(driver, "vb_login_password").write(password);
        log.info("Input password: " + password);
        return this;
    }

    @Step("Click on the LOG IN button")
    public MyJefitPage clickLogInButton(){
        new Button(driver, "Log in").click();
        log.info("Click on LOG IN button");
        return new MyJefitPage(driver);
    }

    @Step("Login with valid data")
    public MyJefitPage loginWithValidData(){
        open();
        log.info("Open LoginPage");
        userNameAndPassword("uwucde@mailto.plus","77721185948934James*");
        log.info("Input login and password");
        return clickLogInButton();

    }

    @Step("Get an error message")
    public String getErrorMessage() {
        log.info("Get the error text by :" +ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }


    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element: " + LOG_IN_TITTLE);
        return isExist(LOG_IN_TITTLE);
    }
}
