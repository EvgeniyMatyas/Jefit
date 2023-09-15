package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Log4j2

public class BodyPartPage extends BasePage{

    public static final By BODY_PART_TITTLE = By.id("bodypartheader");
    public static final By EXERCISE_NAME = By.xpath("//strong[@id='bodyparttext']");
    public BodyPartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get Note value")
    public String getExerciseName(){
        String[] value = driver.findElement(EXERCISE_NAME).getText().split(" ");
        log.info("Return " + value[0].trim());
        return value[0].trim();
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + BODY_PART_TITTLE);
        return isExist(BODY_PART_TITTLE);
    }
}
