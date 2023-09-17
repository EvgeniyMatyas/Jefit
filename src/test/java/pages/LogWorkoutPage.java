package pages;

import com.github.javafaker.Faker;
import elements.MainButton;
import elements.IdButton;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.BodyStats;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.ThreadLocalRandom;

@Log4j2
public class LogWorkoutPage extends BasePage {

    public static final By BODY_STATS_TITLE = By.xpath("//strong[text()='Body Stats']");
    public static final By LOG_WORKOUT_BUTTON = By.xpath("//a[normalize-space()='Log Workout']");
    public static final By CREATE_NOTE_BUTTON = By.xpath("//button[text()='Create Note']");
    public static final By NOTE_TEXT = By.xpath("descendant::div[@class = 'fixed-note'][last()]");
    public static final By NOTE_TEXT_AREA = By.xpath("//div[@class = 'add-note-layout']/form/textarea");
    public static final By DELETE_NOTE = By.xpath("//div[@class='delete-note-button']");

    Faker faker = new Faker();
    String text = faker.chuckNorris().fact();
    String bodyStatsFieldValue = "//strong[text()=' %s : ']/parent::a";



    public LogWorkoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Log Workout page")
    public LogWorkoutPage open() {
        driver.findElement(LOG_WORKOUT_BUTTON).click();
        log.info("Open Log Workout Page by " + LOG_WORKOUT_BUTTON);
        return this;
    }

    @Step("Get text by faker")
    public String returnNoteFakerText() {
        log.info("Return text : " + text);
        return text;
    }

    @Step("Get Note value")
    public String getNoteText() throws InterruptedException {
        String[] value = driver.findElement(NOTE_TEXT).getText().split(":");
        log.info("Return " + value[1].trim());
        return value[1].trim();
    }

    @Step("Create Note")
    public LogWorkoutPage createNote() {
        driver.findElement(NOTE_TEXT_AREA).sendKeys(text);
        log.info("Write " + text + " into Note Text Area by " + NOTE_TEXT_AREA);
        driver.findElement(CREATE_NOTE_BUTTON).click();
        log.info("Click Create Note button by " + CREATE_NOTE_BUTTON);
        return this;
    }

    @Step("Delete Note")
    public void deleteNote() {
        new IdButton(driver, "edit-note").click();
        WebElement button = driver.findElement(DELETE_NOTE);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        log.info("Click on Delete button");
 //       driver.findElement(DELETE_NOTE).click();
        new IdButton(driver, "save-note").click();
    }

    @Step("Delete body stats")
    public void deleteBodyStats() {
        new IdButton(driver, "delete-body-stats").click();
    }

    @Step("Click Add Body Stats Button")
    public LogWorkoutPage clickAddBodyStatsButton() {
        new IdButton(driver, "edit-body-stats").click();
        return this;
    }


    @Step("Click Notes Add button")
    public LogWorkoutPage clickNotesAddButton() {
        new IdButton(driver, "add-note").click();
        return this;
    }


    @Step("Create {bodyStats}")
    public LogWorkoutPage createBodyStats(BodyStats bodyStats) {
        new Input(driver, "weight").write(bodyStats.getWeight());
        new Input(driver, "fatpercent").write(bodyStats.getBodyFat());
        new Input(driver, "height").write(bodyStats.getHeight());
        new Input(driver, "chest").write(bodyStats.getChest());
        new Input(driver, "waist").write(bodyStats.getWaist());
        new Input(driver, "arms").write(bodyStats.getArms());
        new Input(driver, "shoulders").write(bodyStats.getShoulders());
        new Input(driver, "forearms").write(bodyStats.getForeams());
        new Input(driver, "neck").write(bodyStats.getNeck());
        new Input(driver, "hips").write(bodyStats.getHips());
        new Input(driver, "thighs").write(bodyStats.getThighs());
        new Input(driver, "calves").write(bodyStats.getCalves());
        log.info("Create body stats and click Done button  ");
        return clickDoneBodyStats();
    }


    @Step("Get text at field {fieldName} ")
    public String getBodyStatsValue(String fieldName) {
        log.info("Return the text from the field - " + fieldName);
        return driver.findElement(By.xpath(String.format(bodyStatsFieldValue, fieldName))).getText().replaceAll("[^0-9]", "");
    }


    @Step("Click Done Body Status Button")
    public LogWorkoutPage clickDoneBodyStats() {
        new IdButton(driver, "submit-body-stats").click();
        return this;
    }



    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + BODY_STATS_TITLE);
        return isExist(BODY_STATS_TITLE);
    }


}