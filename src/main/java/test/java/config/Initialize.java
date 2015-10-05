package test.java.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmytro_Moskalenko2 on 10/1/2015.
 */
public class Initialize {


    public WebDriver initialize() {
        WebDriver driver;
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://amazon.com");
        return driver;

    }
}