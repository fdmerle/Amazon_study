package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Button extends Element {

    public Button(WebDriver driver, By by) {
        super(driver, by);
    }

    public void click(By element) {
        driver.findElement(element).click();
    }
    public boolean ifEnable(By element) {
        return driver.findElement(element).isEnabled();


    }
}
