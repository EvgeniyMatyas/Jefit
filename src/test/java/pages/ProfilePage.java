package pages;

import elements.Input;
import elements.RadioButton;
import elements.Select;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage extends BasePage{
    public static final By PROFILE_TITTLE = By.xpath("//strong[text()='Setup Your Profile']");
    public static final By CREATE_PROFILE_BUTTON = By.xpath("//input[contains(@class, 'btn-primary')]");
 // Под регистрацию  public static final By MODAL_WINDOW_TITTLE = By.xpath("//h1[text()=' Welcome to Jefit! ']");
// Под регистрацию   public static final By DISPLAY_TITTLE = By.xpath("//div[@class = 'reveal-modal-bg']");
    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @Step("Open the profile page")
    public ProfilePage openProfilePage(){
        driver.get(BASE_URL + "my-jefit/profile/");
        return this;
    }

    @Step("Setting up your profile")
    public ProfilePage createProfile(){
        new Select(driver,"month").selectDate("January");
        new Select(driver,"dt").selectDate("4");
        new Select(driver,"year").selectDate("1989");
        new RadioButton(driver,"kg/cm ").clickOnRadioButton();
        new Input(driver,"Height").write("188");
        new Input(driver,"Current Weight").write("89");
        new RadioButton(driver,"Male").clickOnRadioButton();
        return clickCreateProfileButton();
    }

    public ProfilePage clickCreateProfileButton(){
        driver.findElement(CREATE_PROFILE_BUTTON).click();
        return new ProfilePage(driver);
    }



    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_TITTLE);
    }
}
