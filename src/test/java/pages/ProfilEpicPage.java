package pages;


import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

@Log4j2

public class ProfilEpicPage extends BasePage{

    public static final By SELECT_FILE_BUTTON = By.id("avatarupload");
    public static final By UPLOAD_BUTTON = By.xpath("//input[@class='picturepostButton']");
    public static final By PROFILEPIC_TITTLE = By.xpath("//strong[text()='Profile Picture Setup']");

    public ProfilEpicPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening the Profilepic page")
    public ProfilEpicPage open(){
        driver.get(BASE_URL + "my-jefit/profilepic.php");
        log.info("Open Profilepic page with URL: "+ BASE_URL+"my-jefit/profilepic.php");
        return this;
    }

    @Step("Download an image")
    public ProfilEpicPage downloadFile(){
        File file = new File("src/test/resources/kachok.jpg");
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(file.getAbsolutePath());
        log.info("Сhoosing a picture : "+ SELECT_FILE_BUTTON+"src/test/resources/kachok.jpg");
        driver.findElement(UPLOAD_BUTTON).click();
        log.info("Click on Upload button with XPath: " + UPLOAD_BUTTON);
        return this;
    }


    @Override
    public boolean isPageOpen() {
        return isExist(PROFILEPIC_TITTLE);
    }

}
