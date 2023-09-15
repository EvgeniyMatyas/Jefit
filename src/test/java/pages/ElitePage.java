package pages;

import elements.MainButton;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ElitePage extends BasePage {
    public static final By ELITE_TITTLE = By.xpath("//span[text()='Plans that suit you best']");

    public ElitePage(WebDriver driver) {
        super(driver);
    }



    @Step("Open Get elite page")
    public ElitePage openElitePage() {
        new MainButton(driver,"Elite").click();
        log.info("Click on Elite button with XPath");
        return this;
    }


    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + ELITE_TITTLE);
        return isExist(ELITE_TITTLE);
    }
}
