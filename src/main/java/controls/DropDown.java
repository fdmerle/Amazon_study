package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDown extends Element {

    public DropDown(WebDriver driver, By by) {
        super(driver, by);
    }

    public void setSelectField(By value,String value1) {
        setSelectField(driver.findElement(value), value1);
    }

    public void setSelectField(WebElement webElement, String value1) {
        Select dropdown = new Select(webElement);
        dropdown.selectByVisibleText(value1);

    }

    public void setSelectField(WebElement webElement, int value1) {
        Select dropdown = new Select(webElement);

        dropdown.selectByIndex(value1);

    }
}
