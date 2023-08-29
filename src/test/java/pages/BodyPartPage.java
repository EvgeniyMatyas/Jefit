package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BodyPartPage extends BasePage{

    public static final By BODY_PART_TITTLE = By.id("bodypartheader");
    String exerciseName = "//strong[@id='bodyparttext']";
    public BodyPartPage(WebDriver driver) {
        super(driver);
    }

    public String getExerciseName(){
        //TODO
        return driver.findElement(By.xpath(exerciseName)).getText();
    }

    @Override
    public boolean isPageOpen() {
        return isExist(BODY_PART_TITTLE);
    }
}
