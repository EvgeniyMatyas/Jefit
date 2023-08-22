package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2

public class ExercisesPage extends BasePage{


    public static final By EXERCISE_TITTLE = By.xpath("//span[text()='JEFIT Exercise Database']");
    String bodyLocator = "//div[@class='col-4 col-md-3 my-3 rounded-border']";

    public ExercisesPage(WebDriver driver) {
        super(driver);
    }


    @Step("opening the Exercises page")
    public ExercisesPage open(){
        driver.get(BASE_URL + "exercises/");
        log.info("Open Exercises page with URL: "+ BASE_URL+"exercises/");
        return this;
    }

    public String getBodyNameFromList(){
        List<WebElement> list = driver.findElements(By.xpath(bodyLocator));
        return list.get(0).getText();
    }
    public void clickBodyNameFromList(){
        List<WebElement> list = driver.findElements(By.xpath(bodyLocator));
        list.get(0).click();
    }

    @Override
    public boolean isPageOpen() {
        return isExist(EXERCISE_TITTLE);
    }
}
