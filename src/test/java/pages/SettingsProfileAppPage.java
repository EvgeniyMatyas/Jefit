package pages;

import elements.ButtonWithText;
import elements.SelectDropdown;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;



@Log4j2
public class SettingsProfileAppPage extends BasePage {

    public static final By SETTINGS_TITTLE = By.xpath("//h2[text()='Manage your Profile and App Settings below']");
    public static final By SAVE_PROFILE_BUTTON = By.xpath("//button[@value='Save Settings']");
    public static final By MONTH_OPTIONS = By.xpath("//select[@id='monthSelect']/option");
    public static final By DATE_OPTIONS = By.xpath("//select[@id='dateSelect']/option");
    public static final By YEAR_OPTIONS = By.xpath("//select[@id='yearSelect']/option");
    public static final By MONTH_SELECT = By.xpath("//select[@id='monthSelect']");
    public static final By DATE_SELECT = By.xpath("//select[@id='dateSelect']");
    public static final By YEAR_SELECT = By.xpath("//select[@id='yearSelect']");


    public String newMonthOfBirth;
    public String newDateOfBirth;
    public String newYearOfBirth;

    public String savedMonthOfBirth;
    public String savedDateOfBirth;
    public String savedYearOfBirth;
    public SettingsProfileAppPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Profile App settings")
    public SettingsProfileAppPage openProfileAppSettings() {
        driver.get(BASE_URL + "my-jefit/settings/");
        log.info("Open Profile App Settings page with URL: "+ BASE_URL+"my-jefit/settings/");
        return this;
    }

    @Step("Edit Data Of Birth")
    public SettingsProfileAppPage editDataOfBirth() {

        SelectDropdown dropdownMonth = new SelectDropdown(driver, "month");
        dropdownMonth.click();
        List<WebElement> monthInDropdown = driver.findElements(MONTH_OPTIONS);
        int monthSize = monthInDropdown.size();
        int randomMonth = ThreadLocalRandom.current().nextInt(0, monthSize);
        monthInDropdown.get(randomMonth).click();


        SelectDropdown dropdownDate = new SelectDropdown(driver, "dt");
        dropdownDate.click();
        List<WebElement> dateInDropdown = driver.findElements(DATE_OPTIONS);
        int dateSize = dateInDropdown.size();
        int randomDate = ThreadLocalRandom.current().nextInt(0, dateSize);
        dateInDropdown.get(randomDate).click();

        SelectDropdown dropdownYear = new SelectDropdown(driver, "year");
        dropdownYear.click();
        List<WebElement> yearsInDropdown = driver.findElements(YEAR_OPTIONS);
        int yearsSize = yearsInDropdown.size();
        int randomYear = ThreadLocalRandom.current().nextInt(0, yearsSize);
        yearsInDropdown.get(randomYear).click();

        return new SettingsProfileAppPage(driver);
    }

    @Step("Get new month of Birth")
    public String getNewMonthOfBirth() {
        log.info("Get New Month Of Birth");
        Select newMonth = new Select(driver.findElement(MONTH_SELECT));
        newMonthOfBirth = newMonth.getFirstSelectedOption().getText();
        return newMonthOfBirth;
    }



    @Step("Get new date of Birth")
    public String getNewDateOfBirth() {
        log.info("Get New Date Of Birth");
        Select newDate = new Select(driver.findElement(DATE_SELECT));
        newDateOfBirth = newDate.getFirstSelectedOption().getText();
        return newDateOfBirth;
    }

    @Step("Get new year of Birth")
    public String getNewYearOfBirth() {
        log.info("Get New Year Of Birth");
        Select newYear = new Select(driver.findElement(YEAR_SELECT));
        newYearOfBirth = newYear.getFirstSelectedOption().getText();
        return newYearOfBirth;
    }

    @Step("Get saved month of Birth")
    public String getSavedMonthOfBirth() {
        log.info("Get Saved Month Of Birth");
        SelectDropdown dropdownMonth = new SelectDropdown(driver, "month");
        savedMonthOfBirth = dropdownMonth.getSavedSelectedOption();
        return savedMonthOfBirth;
    }

    @Step("Get saved date of Birth")
    public String getSavedDateOfBirth() {
        log.info("Get Saved Month Of Birth");
        SelectDropdown dropdownDate = new SelectDropdown(driver, "dt");
        savedDateOfBirth = dropdownDate.getSavedSelectedOption();
        return savedDateOfBirth;
    }

    @Step("Get saved year of Birth")
    public String getSavedYearOfBirth() {
        log.info("Get Saved Month Of Birth");
        SelectDropdown dropdownYear = new SelectDropdown(driver, "year");
        savedYearOfBirth = dropdownYear.getSavedSelectedOption();
        return savedYearOfBirth;
    }

    @Step("Save data of birth")
    public SettingsProfileAppPage saveDataOfBirth() {
        new ButtonWithText(driver, "Save Profile").clickButtonWithText();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SAVE_PROFILE_BUTTON));
        return new SettingsProfileAppPage(driver);
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + SETTINGS_TITTLE);
        return isExist(SETTINGS_TITTLE);
    }

}