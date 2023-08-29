package pages;

import elements.FooterButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2

public class ExercisesPage extends BasePage{


    public static final By EXERCISE_TITTLE = By.xpath("//span[@class ='raven-heading-title' and text()='JEFIT Exercise Database']");
    String bodyLocator = "//div[@class='col-4 col-md-3 my-3 rounded-border']";

    public ExercisesPage(WebDriver driver) {
        super(driver);
    }


    @Step("Open Exercise Page")
    public ExercisesPage openExercisePage() {
        new FooterButton(driver, "Exercises").click();
        return this;
    }

    public String getBodyNameFromList(){
        List<WebElement> list = driver.findElements(By.xpath(bodyLocator));
        return list.get(2).getText();
    }
    public void clickBodyNameFromList(){
        List<WebElement> list = driver.findElements(By.xpath(bodyLocator));
        list.get(2).click();
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + EXERCISE_TITTLE);
        return isExist(EXERCISE_TITTLE);
    }
}
