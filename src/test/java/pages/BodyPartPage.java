package pages;

import org.openqa.selenium.WebDriver;

public class BodyPartPage extends BasePage{
    public BodyPartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return false;
    }
}
