package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2

public class Select {
    String selectLocator = "//div[contains(@style, 'margin-left:10px')]//select[@name = '%s']";
    String optionLocator = "//option[text()='%s'] ";
    WebDriver driver;
    String date;


    public Select(WebDriver driver, String date) {
        this.driver = driver;
        this.date = date;

    }

    public void selectDate(String option) {

        driver.findElement(By.xpath(String.format(selectLocator, this.date))).click();
        log.info("Click on dropdown with label " + this.date);
        driver.findElement(By.xpath(String.format(optionLocator, option))).click();
        log.info("Select option " + option);

    }
}


