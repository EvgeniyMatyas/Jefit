package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2

public class MainButton {
    WebDriver driver;
    String text;

    String footerLocator = "//a[text()='%s']";
    public MainButton(WebDriver driver, String text) {
        this.driver = driver;
        this.text = text;
    }

    public void click() {
        driver.findElement(By.xpath(String.format(footerLocator, text))).click();
        log.info("Click on button with text : " + text);
    }


}
