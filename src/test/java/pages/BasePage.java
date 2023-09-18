package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PropertyReader;


import java.util.NoSuchElementException;

@Log4j2

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public static final String BASE_URL = System.getenv().getOrDefault("JEFIT_URL", PropertyReader.getProperty("jefit.url"));


    public BasePage(WebDriver driver) {

        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }


    public abstract boolean isPageOpen();

    @Step("Check the presence of the locator, in case of absence, the method will give false")
    public boolean isExist(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (NoSuchElementException e){
            log.error("Page is not loaded");
            return false;
        }
}
}