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
public class SettingsMembershipPage extends BasePage {
    public static final By ACCOUNT_TYPE = By.xpath("//div[@style='font-size: 18px;']");
    public static final By MEMBERSHIP_PAGE_TITLE = By.xpath("//h2[text()='Manage your membership']");

    public SettingsMembershipPage(WebDriver driver) {
        super(driver);
    }



    @Step("Open Membership settings")
    public SettingsMembershipPage openMembershipSettings() {
        driver.get(BASE_URL + "my-jefit/settings/");
        log.info("Open Profile App Settings page with URL: "+ BASE_URL+"my-jefit/settings/");
        new MainButton(driver, "Membership Settings").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(MEMBERSHIP_PAGE_TITLE));
        return new SettingsMembershipPage(driver);
    }

    @Step("Get account type")
    public String getAccountType() {
        log.info("Get text from " + ACCOUNT_TYPE);
        return driver.findElement(ACCOUNT_TYPE).getText();
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + ACCOUNT_TYPE);
        return isExist(ACCOUNT_TYPE);
    }

}
