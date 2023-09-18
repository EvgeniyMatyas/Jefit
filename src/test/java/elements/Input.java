package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class Input {
    String inputLocator = "//input[@name = '%s']";
    String aboutMeInputLocator= " //td[normalize-space(text()) = '%s']/ancestor::tr//input";

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
        log.info("Write into input with label: " + this.label );
    }

    public void aboutMeWrite(String text) {
        driver.findElement(By.xpath(String.format(aboutMeInputLocator, this.label))).clear();
        log.info("Clear input with label  " + this.label);
        driver.findElement(By.xpath(String.format(aboutMeInputLocator, this.label))).sendKeys(text);
        log.info("Wtite into input with label: " + this.label + "text: " + text);
    }


    public void click() {
        driver.findElement(By.xpath(String.format(inputLocator, this.label))).click();
        log.info("Click on input with name " + label);
    }
}


