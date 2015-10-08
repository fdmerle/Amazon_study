package controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {

    protected WebDriver driver;
    private By by;

    public Element(WebDriver driver, By by){
        this.driver = driver;
        this.by = by;
    }

    public WebElement get() {
        return driver.findElement(by);
    }

    public void set(By by) {
        this.by = by;
    }
}

