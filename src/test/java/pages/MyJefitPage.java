package pages;


import elements.Button;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import models.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class MyJefitPage extends BasePage{

    public static final By MY_JEFIT_TITTLE = By.xpath("//a[text()='Home']");
    public static final By STATUS_TEXT= By.xpath("(//div[@class='col-8'])[2]");

    public MyJefitPage(WebDriver driver) {
        super(driver);
    }

    @Step("Edit status")
    public MyJefitPage writingTheStatus(Status status) {
        new TextArea(driver, "statusinputbox").write(status.getStatusText());
        new Button(driver, "Post").click();
        log.info("writing the status");
        return this;
    }

    @Step("Get status text")
    public String getStatusText() {
        log.info("Get status text ");
        return driver.findElement(STATUS_TEXT).getText();
    }

    @Step("Get faker text")
    public String returnFakerText() {
        log.info("Return text : " + getStatusText());
        return getStatusText();
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + MY_JEFIT_TITTLE);
        return isExist(MY_JEFIT_TITTLE);
    }
}
