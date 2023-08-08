package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
@Log4j2

public class RadioButton {
    String radioButtonLocator = "//span[text()='%s']/ancestor::div[contains(@class, 'container-fluid')]//input";

    WebDriver driver;
    String label;

    public RadioButton(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void clickOnRadioButton() {
        driver.findElement(By.xpath(String.format(radioButtonLocator, this.label))).click();
        log.info("Click with label  " + this.label);
    }
}
