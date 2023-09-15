package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class PopularPostPage extends BasePage{
    public static final By POPULAR_POST_TITTLE = By.xpath("//section[@class='ast-archive-description']");
    String postNameLocator= "//h1[@class='entry-title']";

    public PopularPostPage(WebDriver driver) {
        super(driver);
    }

    public String getPostName() {
      return driver.findElement(By.xpath(postNameLocator)).getText();

    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + POPULAR_POST_TITTLE);
        return isExist(POPULAR_POST_TITTLE);
    }
}
