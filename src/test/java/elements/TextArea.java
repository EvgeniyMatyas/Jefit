package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class TextArea {
    WebDriver driver;
    String name;
    String textAreaLocator = "//td[normalize-space(text()) = '%s']/ancestor::div[@class='middle730']//textarea";

    public TextArea(WebDriver driver, String name) {
        this.driver = driver;
        this.name = name;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(textAreaLocator, this.name))).clear();
        log.info("Clear all text Text Area with name " + name);
        driver.findElement(By.xpath(String.format(textAreaLocator, this.name))).sendKeys(text);
        log.info("Write " + text + " into Text Area with name " + name);
    }


}