package pages;

import elements.Button;
import elements.Input;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.AboutMe;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class AboutMePage extends BasePage {
    public static final By ABOUT_ME_TITLE = By.xpath("//strong[text() = 'About Me']");


    public AboutMePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open About me page")
    public AboutMePage open() {
        driver.get(BASE_URL + "my-jefit/aboutme/");
        log.info("Open About me page");
        return this;
    }

    @Step("Create About me")
    public AboutMePage create(AboutMe aboutMe) {
        new Input(driver, "Location").aboutMeWrite(aboutMe.getLocation());
        new Input(driver, "Occupation").aboutMeWrite(aboutMe.getOccupation());
        new TextArea(driver, "Interests & Hobbies").aboutMeWrite(aboutMe.getInterestsHobbies());
        new TextArea(driver, "Why Do You Workout?").aboutMeWrite(aboutMe.getWhyDoYouWorkout());
        new TextArea(driver, "How Did You Start?").aboutMeWrite(aboutMe.getHowDidYouStart());
        new TextArea(driver, "What Motivates You?").aboutMeWrite(aboutMe.getWhatMotivatesYou());
        new TextArea(driver, "Main Goal").aboutMeWrite(aboutMe.getMainGoal());
        new TextArea(driver, "Long Term Goals").aboutMeWrite(aboutMe.getLongTermGoals());
        new TextArea(driver, "Short Term Goals").aboutMeWrite(aboutMe.getShortTermGoals());
        new TextArea(driver, "Music").aboutMeWrite(aboutMe.getMusic());
        new TextArea(driver, "Food").aboutMeWrite(aboutMe.getFood());
        new TextArea(driver, "Supplements").aboutMeWrite(aboutMe.getSupplements());
        new TextArea(driver, "Exercises").aboutMeWrite(aboutMe.getExercises());
        new TextArea(driver, "Magazines").aboutMeWrite(aboutMe.getMagazines());
        new TextArea(driver, "Movies").aboutMeWrite(aboutMe.getMovies());
        log.info("Create " + aboutMe);
        return clickSaveButton();
    }


    @Step("Click Save button")
    public AboutMePage clickSaveButton() {
        new Button(driver,"Save").click();
        return new AboutMePage(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + ABOUT_ME_TITLE);
        return isExist(ABOUT_ME_TITLE);
    }
}