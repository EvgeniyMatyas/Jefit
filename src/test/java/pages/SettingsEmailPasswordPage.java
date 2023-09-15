package pages;

import elements.MainButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;



@Log4j2
public class SettingsEmailPasswordPage extends BasePage {

    public static final By EMAIL_PASSWORD_PAGE_TITLE = By.xpath("//h2[text()='Manage your Email']");
    public static final By CURRENT_PASSWORD_INPUT = By.xpath("//input[@id='currentpassword']");


    public SettingsEmailPasswordPage(WebDriver driver) {
        super(driver);
    }



    @Step("Open Email Password Settings")
    public SettingsEmailPasswordPage openEmailPasswordSettings() {
        driver.get(BASE_URL + "my-jefit/settings/");
        log.info("Open Profile App Settings page with URL: "+ BASE_URL+"my-jefit/settings/");
        new MainButton(driver, "Email / Password").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(EMAIL_PASSWORD_PAGE_TITLE));
        return new SettingsEmailPasswordPage(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + CURRENT_PASSWORD_INPUT);
        return isExist(CURRENT_PASSWORD_INPUT);
    }


}
