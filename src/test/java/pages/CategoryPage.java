package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class CategoryPage extends BasePage{

    public static final By CATEGORY_TITTLE = By.xpath("//section[@class='ast-archive-description']");
    String postNameLocator= "//h1[contains(@class,'page-title')]";

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    public String getCategoryName() {
        return driver.findElement(By.xpath(postNameLocator)).getText();

    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + CATEGORY_TITTLE);
        return isExist(CATEGORY_TITTLE);
    }
}
