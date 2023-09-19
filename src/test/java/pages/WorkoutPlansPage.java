package pages;

import elements.MainButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class WorkoutPlansPage extends BasePage {
    public static final By JEFIT_WORKOUT_ROUTINE_DATABASE = By.xpath("//span[text()='JEFIT Workout Routine Database']");


    public WorkoutPlansPage(WebDriver driver) {
        super(driver);
    }



    @Step("Open Workout plans")
    public WorkoutPlansPage openWorkoutPlans() {
        new MainButton(driver, "Workout Plans").click();
        return this;
    }



    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element :" + JEFIT_WORKOUT_ROUTINE_DATABASE);
        return isExist(JEFIT_WORKOUT_ROUTINE_DATABASE);
    }

}
