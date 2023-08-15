package pages;

import elements.Input;
import elements.RadioButton;
import elements.Select;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProfilePage extends BasePage{
    public static final By PROFILE_TITTLE = By.xpath("//strong[text()='Setup Your Profile']");
    public static final By CREATE_PROFILE_BUTTON =By.id("finish-basic-setup");

    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    @Step("Setting up your profile")
    public MyJefitPage createProfile(){
        new Select(driver,"month").selectDate("January");
        new Select(driver,"dt").selectDate("4");
        new Select(driver,"year").selectDate("1989");
        new RadioButton(driver,"1").selectRadioButton();
        new Input(driver,"Height").write("188");
        new Input(driver,"Current Weight").write("89");
        new RadioButton(driver,"M").selectRadioButton();
        return clickCreateProfileButton();
    }
    @Step("Click the create profile button")
    public MyJefitPage clickCreateProfileButton(){
        driver.findElement(CREATE_PROFILE_BUTTON).click();
        return new MyJefitPage(driver);
    }


    @Override
    public boolean isPageOpen() {
        return isExist(PROFILE_TITTLE);
    }
}
