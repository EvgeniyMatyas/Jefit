package pages;


import elements.Button;
import elements.MainButton;
import elements.TextArea;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class MyJefitPage extends BasePage{

    public static final By MY_JEFIT_TITTLE = By.xpath("//a[text()='Home']");
    public static final By BODY_STATS_TITTLE = By.xpath("//div[text() = 'Latest Body Stats']");
    public static final By TRAINING_STATS_TITTLE = By.xpath("//strong[text() = 'Benchmark Exercise Progress']");
    public static final By PROGRESS_PHOTOS_TITTLE = By.xpath("//strong[text() = ' Progress Pictures ']");

    String fileUploaded = " //div[normalize-space(text()) = 'Has posted a new profile picture.']";
    public static final By STATUS_TEXT= By.xpath("(//div[@class='col-8'])[2]");
    public MyJefitPage(WebDriver driver) {
        super(driver);
    }
    @Step("Opening the MyJefit page")
    public MyJefitPage open() {
        driver.get(BASE_URL + "my-jefit/");
        log.info("Open MyJefit page with URL: " + BASE_URL + "my-jefit/");
        return this;
    }
    @Step("Take the text that the picture is loaded")
    public String getTextPictureUploaded(){
        log.info("Take the picture upload message :" +fileUploaded);
        return driver.findElement(By.xpath(fileUploaded)).getText();
    }

    @Step("Click on the Home button")
    public MyJefitPage clickHomeButton(){
        new MainButton(driver,"Home").click();
        log.info("Click on Home button with XPath");
        return this;
    }

    @Step("Write a status")
    public MyJefitPage writeStatus(String statusText){
        new TextArea(driver, "statusinputbox").write(statusText);
        log.info("Input the status in the field: ");
        return this;
    }

    @Step("Click on the Post button")
    public MyJefitPage clickPostButton() {
        new Button(driver,"Post").click();
        log.info("Click on Post button with XPath: ");
        return this;
    }

    @Step("Take the status text ")
    public String getStatusText(){
        String[] value = driver.findElement(STATUS_TEXT).getText().split(":");
        log.info("Return " + value[1].trim());
        return value[1].trim();
    }

    @Step("page refresh")
    public MyJefitPage pageRefresh(){
        driver.navigate().refresh();
        return this;
    }

    @Step("Click on the Body Stats button")
    public MyJefitPage clickBodyStatsButton(){
        new MainButton(driver,"Body Stats").click();
        log.info("Click on Body Stats button with XPath");
        return this;
    }

    @Step("Click on the Training Stats button")
    public MyJefitPage clickTrainingStatsButton(){
        new MainButton(driver,"Training Stats").click();
        log.info("Click on Training Stats button with XPath");
        return this;
    }

    @Step("Click on the Progress Photos button")
    public MyJefitPage clickProgressPhotosButton(){
        new MainButton(driver,"Progress Photos").click();
        log.info("Click on Progress Photos button with XPath");
        return this;
    }

    public boolean isBodyStatusOpen() {
        return isExist(BODY_STATS_TITTLE);
    }

    public boolean isTrainingStatsOpen() {
        return isExist(TRAINING_STATS_TITTLE);
    }

    public boolean isProgressPhotosOpen() {
        return isExist(PROGRESS_PHOTOS_TITTLE);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + MY_JEFIT_TITTLE);
        return isExist(MY_JEFIT_TITTLE);
    }
}
