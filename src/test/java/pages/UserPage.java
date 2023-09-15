package pages;


import elements.MainButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2

public class UserPage extends BasePage{

    public static final By USER_NAME_TITTLE = By.xpath("//span[text()='Weight']/ancestor::div[@class='aboutmeBox']");
    String fieldValue = "//span[text()='%s']/parent::div";
    public static final By ABOUT_ME_LIST = By.xpath("//span[@style='font-weight: bold']/parent::div");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open User Page")
    public UserPage open() {
        driver.get(BASE_URL + "user/jamezzus");
        return this;
    }

    @Step("Click on the button More About Me")
    public UserPage clickMoreAboutMeButton() {
        new MainButton(driver, "More About Me").click();
        log.info("Open User Page");
        return this;

    }

    @Step("Get value field {fieldName}")
    public String getFieldValue(String fieldName) {
        String[] value = driver.findElement(By.xpath(String.format(fieldValue, fieldName))).getText().split(":");
        log.info("Get text : " + value[1].trim() + " from field " + fieldName);
        return value[1].trim();
    }

    public boolean getSizeListOfAboutMe(){
        List<WebElement> list = driver.findElements(ABOUT_ME_LIST);
        return list.equals(list);
    }


    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + USER_NAME_TITTLE);
        return isExist(USER_NAME_TITTLE);
    }
}
