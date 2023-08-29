package pages;


import elements.FooterButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class UserPage extends BasePage{

    public static final By USER_NAME_TITTLE = By.xpath("//span[text()='Weight']/ancestor::div[@class='aboutmeBox']");
    String fieldValue = "//span[text()='%s']/parent::div";

    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open User Page")
    public UserPage open() {
        driver.get(BASE_URL + "user/yxobx-mailto-plus");
        new FooterButton(driver, "More About Me").click();
        log.info("Open User Page");
        return this;
    }



    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + USER_NAME_TITTLE);
        return isExist(USER_NAME_TITTLE);
    }
}
