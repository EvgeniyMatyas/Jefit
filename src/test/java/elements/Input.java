package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class Input {
    String inputLocator = "//div[text()='%s']/ancestor::div[@class='w-100']//input";
    String aboutMeInputLocator= "//td[normalize-space(text()) = '%s']/ancestor::div[@class='middle730']//input";

    WebDriver driver;
    String label;

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).clear();
        log.info("Clear input with label  " + this.label);
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).sendKeys(text);
        log.info("Wtite into input with label: " + this.label + "text: " + text);
    }

    public void aboutMeWrite(String text) {
        driver.findElement(By.xpath(String.format(aboutMeInputLocator, this.label))).clear();
        log.info("Clear input with label  " + this.label);
        driver.findElement(By.xpath(String.format(aboutMeInputLocator, this.label))).sendKeys(text);
        log.info("Wtite into input with label: " + this.label + "text: " + text);
    }
}


