package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class LoginPage extends BasePage{

    public static final By USER_NAME_OR_EMAIL = By.id("navbar_username");
    public static final By PASSWORD = By.id("navbar_password");
    public static final By LOG_IN_BUTTON = By.xpath("//input[@class = 'loginblueButton1']");
    public static final By ERROR_MESSAGE = By.id("invalidpassworderrormessage");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("opening the registration page")
    public LoginPage open(){
        driver.get(BASE_URL + "login");
        log.info("Open Login page with URL: "+ BASE_URL+"login");
        return this;
    }

    @Step("Enter Username or Email: '{name}' and Password: '{password}'")
    public LoginPage userNameOrEmailAndPassword(String name,String password) {
        driver.findElement(USER_NAME_OR_EMAIL).sendKeys(name);
        log.info("Input the USERNAME or EMAIL in the field: " + name);
        driver.findElement(PASSWORD).sendKeys(password);
        log.info("Input password: " + password);
        return this;
    }

    @Step("Click on the LOG IN button")
    public ProfilePage clickLogInButton(){
        driver.findElement(LOG_IN_BUTTON).click();
        log.info("Click on LOG IN button with XPath: " + LOG_IN_BUTTON);
        return new ProfilePage(driver);
    }

    @Step("Get an error message")
    public String getErrorMessage() {
        log.info("Take the error message :" +ERROR_MESSAGE);
        return driver.findElement(ERROR_MESSAGE).getText();
    }

    @Step("Make sure that you have gone to the login page")
    @Override
    public boolean isPageOpen() {
        log.info("Find element: " +LOG_IN_BUTTON);
        return isExist(LOG_IN_BUTTON);
    }
}
