package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import elements.*;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


@Log4j2

public class MyRoutinesPage extends BasePage{

    public static final By ROUTINE_MANAGER_LINK = By.xpath("//a[text()='Routine Manager']");
    public static final By ROUTINE_NAME = By.xpath("//a[@class='confirmText']/strong");
    public static final By DELETE_ROUTINE_BUTTON = By.xpath("//a[@class = 'confirmText' and contains(@onclick, 'deleteRoutine') ]");
    public static final By NUMBER_OF_ROUTINE = By.xpath("//td[normalize-space()='0/20 Routines Created']");
    public static final By ROUTINE_IS_DELETED = By.xpath("//p[contains(text(),'You have not setup a default routine yet. Please c')]");


    String text = faker.lebowski().character();
    static Faker faker = new Faker();


    public MyRoutinesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open My Routine page")
    public MyRoutinesPage open() {
        driver.get(BASE_URL + "/my-jefit/my-routines/routine-manager.php");
        log.info("Open my routine page by URL");
        return this;
    }

    @Step("Click on the Create New Routine button")
    public MyRoutinesPage clickCreateNewRoutineButton(){
        new MainButton(driver, "Create New Routine").click();
        log.info("Click on Create New Routine button");
        return new MyRoutinesPage(driver);
    }

    @Step("Create New Routine")
    public MyRoutinesPage createNewRoutine() {
        new Input(driver, "rpname").write(text);
        new Select(driver, "daytype").selectRandomOption();
        new Select(driver, "typeselect").selectRandomOption();
        new Select(driver, "levelselect").selectRandomOption();
        new TextArea(driver, "rptext").write(faker.chuckNorris().fact());
        new TextArea(driver, "rtags").write(faker.gameOfThrones().dragon());
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value = 'Save']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        log.info("JS click on Save button");
        return this;
    }

    @Step("Click on the Save button")
    public MyRoutinesPage clickSaveButton(){
        new Button(driver, "Save").click();
        log.info("Click on Save button");
        return new MyRoutinesPage(driver);
    }

    @Step("Get routine name")
    public String getRoutineName() {
        log.info("Get routine name by " + ROUTINE_NAME);
        return driver.findElement(ROUTINE_NAME).getText();
    }

    @Step("Get faker text")
    public String returnRoutineFakerText() {
        driver.findElement(By.xpath("//input[@name = 'rpname']")).getText();
        log.info("Get faker text : " + text);
        return text;
    }

    @Step("Delete routine")
    public MyRoutinesPage deleteRoutine() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(DELETE_ROUTINE_BUTTON));
        driver.findElement(DELETE_ROUTINE_BUTTON).click();
        log.info("Click delete routine button by " + DELETE_ROUTINE_BUTTON);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
        log.info("Switch to alert and accept");
        wait.until(ExpectedConditions.visibilityOfElementLocated(NUMBER_OF_ROUTINE));
        return this;
    }

    @Step("Make sure the Routine is deleted")
    public String routineIsDeletedText() {
        log.info("Get text by " + ROUTINE_IS_DELETED);
        return driver.findElement(ROUTINE_IS_DELETED).getText();
    }


    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + ROUTINE_MANAGER_LINK);
        return isExist(ROUTINE_MANAGER_LINK);
    }
}
