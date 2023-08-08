// TODO: 08.08.2023  
package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class SingUpPage extends BasePage{
    public static final By CREATE_ACCOUNT_TITTLE = By.id("signuplogintitle");
    public static final By USER_NAME = By.id("regusername");
    public static final By EMAIL_ADDRESS = By.id("myemail");
    public static final By PASSWORD = By.id("password");
    public static final By CONFIRM_PASSWORD = By.id("passwordconfirm");
    public static final By RECAPTCHA = By.id("recaptcha-anchor");
    public static final By CREATE_ACCOUNT_BUTTON = By.xpath("//input[@class='loginblueButton1']");
    public SingUpPage(WebDriver driver) {
        super(driver);
    }
    @Step("Opening the website")
    public SingUpPage openJeFit(){
        driver.get(BASE_URL);
        log.info("Open site with URL: " + BASE_URL);
        return this;
    }
    @Step("Opening the account creation page and create account")
    public SingUpPage openSingUpPage() {
        driver.findElement(SING_UP).click();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return this;
    }
    @Step("Enter UserName: '{name}' , Email Address: '{email}' , Password: '{password}' , Confirm Password: '{confirmPassword}'")
    public SingUpPage inputValidationData(String name,String email,String password,String confirmPassword){
            driver.findElement(USER_NAME).sendKeys(name);
            driver.findElement(EMAIL_ADDRESS).sendKeys(email);
            driver.findElement(PASSWORD).sendKeys(password);
            driver.findElement(CONFIRM_PASSWORD).sendKeys(confirmPassword);
            return this;
        }
        @Step("Click on the 'I'm not a robot' button")
        public SingUpPage clickRecaptchaButton(){
            driver.findElement(RECAPTCHA).click();
            return this;
        }


        @Step("Click on the CREATE ACCOUNT button")
        public ProfilePage clickAccountButton(){
            driver.findElement(CREATE_ACCOUNT_BUTTON).click();
            return new ProfilePage(driver);
        }


        @Override
        public boolean isPageOpen () {
            return isExist(CREATE_ACCOUNT_BUTTON);
        }
    }
