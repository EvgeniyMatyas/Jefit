package pages;

import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage{
    public UserPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
}
