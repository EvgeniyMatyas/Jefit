package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyJefitPage extends BasePage{

    public static final By MY_JEFIT_TITTLE = By.xpath("//a[@class='selected' and text()='Home']");
    public MyJefitPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(MY_JEFIT_TITTLE);
    }
}
