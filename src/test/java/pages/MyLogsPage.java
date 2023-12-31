package pages;

import elements.MainButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class MyLogsPage extends BasePage {
    public static final By LOGS_TITLE = By.xpath("//strong[text()='Logs']");
    public static final By CALENDAR_DAY_LOGS = By.xpath("(//td[@class='calenderDay']/a)[15]");
    public static final By EDIT_BODY_STATS = By.xpath("//span[@id='edit-body-stats']");

    public MyLogsPage(WebDriver driver) {
        super(driver);
    }



    @Step("Open My Logs")
    public MyLogsPage openMyLogs() {
        new MainButton(driver, " My Logs").click();
        return new MyLogsPage(driver);
    }

    @Step("Open Logs For Day")
    public MyLogsPage openLogsForDay() {
        driver.findElement(CALENDAR_DAY_LOGS).click();
        log.info("Click Calendar day logs by " + CALENDAR_DAY_LOGS);
        return this;
    }

    @Step("Make sure the Body stats is opened")
    public boolean editBodyStatsIsDisplayed() {
        log.info("Find element : " + EDIT_BODY_STATS);
        return driver.findElement(EDIT_BODY_STATS).isDisplayed();
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + LOGS_TITLE);
        return isExist(LOGS_TITLE);
    }

}
