package pages;

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
    public static final By SAVE_BUTTON = By.xpath("//input[@value='Save' and @class='statusblueButton']");


    public AboutMePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open About 'Me page'")
    public AboutMePage open() {
        driver.get(BASE_URL + "my-jefit/aboutme/");
        log.info("Open About Me page");
        return this;
    }

    @Step("Create {aboutMe}")
    public AboutMePage create(AboutMe aboutMe) {
        new Input(driver, "Location").aboutMeWrite(aboutMe.getLocation());
        new Input(driver, "Occupation").aboutMeWrite(aboutMe.getOccupation());
        new TextArea(driver, "Interests & Hobbies").write(aboutMe.getInterests_Hobbies());
        new TextArea(driver, "Why Do You Workout?").write(aboutMe.getWhy_Do_You_Workout());
        new TextArea(driver, "How Did You Start?").write(aboutMe.getHow_Did_You_Start());
        new TextArea(driver, "What Motivates You?").write(aboutMe.getWhat_Motivates_You());
        new TextArea(driver, "Main Goal").write(aboutMe.getMain_Goal());
        new TextArea(driver, "Long Term Goals").write(aboutMe.getLong_Term_Goals());
        new TextArea(driver, "Short Term Goals").write(aboutMe.getShort_Term_Goals());
        new TextArea(driver, "Music").write(aboutMe.getMusic());
        new TextArea(driver, "Food").write(aboutMe.getFood());
        new TextArea(driver, "Supplements").write(aboutMe.getSupplements());
        new TextArea(driver, "Exercises").write(aboutMe.getExercises());
        new TextArea(driver, "Magazines").write(aboutMe.getMagazines());
        new TextArea(driver, "Movies").write(aboutMe.getMovies());
        log.info("Create " + aboutMe);
        return clickSaveButton();
    }


    @Step("Click 'Save' button")
    public AboutMePage clickSaveButton() {
        driver.findElement(SAVE_BUTTON).click();
        return new AboutMePage(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element --> " + ABOUT_ME_TITLE);
        return isExist(ABOUT_ME_TITLE);
    }
}