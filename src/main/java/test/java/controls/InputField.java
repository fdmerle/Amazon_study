package test.java.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputField extends Element {

    public InputField(WebDriver driver, By by) {
        super(driver, by);
    }

    public void setInputField(By control, String valueToEnter) {
        WebElement inField = driver.findElement(control);
        inField.sendKeys(valueToEnter);
    }

    public void setInputField(WebElement inField, String valueToEnter) {
        inField.sendKeys(valueToEnter);
    }

    public String getInputField(By control) {
        return driver.findElement(control).getText();

    }

    public void Clear(By control) {
        driver.findElement(control).clear();

    }
}
