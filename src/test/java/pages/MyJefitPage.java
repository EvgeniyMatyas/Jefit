package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class MyJefitPage extends BasePage{

    public static final By MY_JEFIT_TITTLE = By.xpath("//a[@class='selected' and text()='Home']");
    public static final By HOME_BUTTON = By.xpath("//a[@class='selected' and text()='Home']");
    public static final By POST_BUTTON = By.xpath("//input[@type='button' and @onclick='setStatus(statusinputbox.value)']");
    String fileUploaded = " //div[normalize-space(text()) = 'Has posted a new profile picture.']";
    String statusTextAreaLocator = "statusinputbox";
    String statusText = "//div[@class='fs-3 cursor-pointer']";
    public MyJefitPage(WebDriver driver) {
        super(driver);
    }
    @Step("Opening the MyJefit page")
    public MyJefitPage open() {
        driver.get(BASE_URL + "my-jefit/");
        log.info("Open MyJefit page with URL: " + BASE_URL + "my-jefit/");
        return this;
    }
    @Step("Take the text that the picture is loaded")
    public String getTextPictureUploaded(){
        log.info("Take the picture upload message :" +fileUploaded);
        return driver.findElement(By.xpath(fileUploaded)).getText();
    }

    @Step("Click on the Home button")
    public MyJefitPage clickHomeButton(){
        driver.findElement(HOME_BUTTON).click();
        log.info("Click on HOME button with XPath: " + HOME_BUTTON);
        return this;
    }

    @Step("Write a status")
    public MyJefitPage writeStatus(String text){
        driver.findElement(By.id(statusTextAreaLocator)).clear();
        driver.findElement(By.id(statusTextAreaLocator)).sendKeys(text);
        return this;
    }

    @Step("Click on the Post button")
    public MyJefitPage clickPostButton() {
        driver.findElement(POST_BUTTON).click();
        log.info("Click on Post button with XPath: " + POST_BUTTON);
        return this;
    }

    @Step("Take the status text ")
    public String getStatusText(){
        log.info("Take the status text :" +statusText);
        return driver.findElement(By.xpath(statusText)).getText();
    }

    @Step("page refresh")
    public MyJefitPage pageRefresh(){
        driver.navigate().refresh();
        return this;
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MY_JEFIT_TITTLE);
    }
}
