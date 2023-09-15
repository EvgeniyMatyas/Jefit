package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Log4j2
public class BlogPage extends BasePage {
    public static final By BLOG_TITTLE = By.xpath("//h2[text()='Popular Posts']");
    String categoriesLocator = "//li[contains(@class,'cat-item')]/a";
    String popularPostLocator = "//a[@class='ss-popular-post-title']";

    public BlogPage(WebDriver driver) {
        super(driver);
    }


    @Step("Open blog page")
    public BlogPage openBlogPage() {
        driver.get(BASE_URL + "blog");
        log.info("Open Blog page with URL: " + BASE_URL + "blog");
        return this;
    }

    public String getTextFromPopularPostList(){
        List<WebElement> list=(driver.findElements((By.xpath(popularPostLocator))));
        log.info("Put projects in the list and get  first element text");
        return list.get(0).getText();
    }
    public void clickFirstFromPopularPostList(){
        List<WebElement> list = (driver.findElements(By.xpath(popularPostLocator)));
        log.info("Put projects in the list and click  first element ");
        list.get(0).click();
    }

    public String getTextFromCategoriesList(){
        List<WebElement> list=(driver.findElements((By.xpath(categoriesLocator))));
        log.info("Put projects in the list and get  first element text");
        return list.get(0).getText();
    }
    public void clickFirstFromCategoriesList(){
        List<WebElement> list = (driver.findElements(By.xpath(categoriesLocator)));
        log.info("Put projects in the list and click  first element ");
        list.get(0).click();
    }

    @Override
    @Step("Find element to make sure the page is open")
    public boolean isPageOpen() {
        log.info("Find element : " + BLOG_TITTLE);
        return isExist(BLOG_TITTLE);
    }


}
