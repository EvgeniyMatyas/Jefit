package pages;


import elements.Button;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

@Log4j2

public class ProfilePicPage extends BasePage{

    public static final By SELECT_FILE_BUTTON = By.id("avatarupload");
    public static final By PROFILE_PIC = By.xpath("//img[@class ='leftProfilePic']");

    public ProfilePicPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening the Profilepic page")
    public ProfilePicPage open(){
        driver.get(BASE_URL + "my-jefit/profilepic.php");
        log.info("Open Profilepic page with URL: "+ BASE_URL+"my-jefit/profilepic.php");
        return this;
    }

    @Step("Upload an image")
    public ProfilePicPage uploadFile(){
        File file = new File("src/test/resources/kachok.jpg");
        driver.findElement(SELECT_FILE_BUTTON).sendKeys(file.getAbsolutePath());
        log.info("Сhoosing a picture : "+ SELECT_FILE_BUTTON+"src/test/resources/kachok.jpg");
        new Button(driver,"Upload Photo").click();
        log.info("Click on Upload button");
        return new ProfilePicPage(driver);
    }

    @Step("Checking that the image is loaded")
    public String fileIsUploaded() {
        WebElement img = driver.findElement(PROFILE_PIC);
        log.info("File is uploaded");
        return img.getAttribute("src");
    }


    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_PIC);
    }

}
