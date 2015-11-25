package config;

import Resources.ConfigValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmytro_moskalenko2 on 10/21/2015.
 */
public class DriverObject extends RemoteWebDriver {
    private WebDriver driver;

    public void pageInit(String browserType) {
        switch (browserType) {
            case "FireFox":
                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile myProfile = profile.getProfile("automation");
                driver = new FirefoxDriver(myProfile);
                break;


            case "Chrome":
                URL urlChrome = DriverObject.class.getClassLoader().getResource("chromedriver.exe");
                String strPathChrome = urlChrome.getPath();
                System.setProperty("webdriver.chrome.driver", strPathChrome);
                driver = new ChromeDriver();
                break;

            case "IE":
                URL urlIE = DriverObject.class.getClassLoader().getResource("IEDriverServer.exe");
                String strPathIE = urlIE.getPath();
                System.setProperty("webdriver.ie.driver", strPathIE);
                driver = new InternetExplorerDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(ConfigValues.DEFAULT_COOLDOWN_FOR_DRIVER_MSEC, TimeUnit.SECONDS);

    }

    public boolean isControlExistOnPage(By locator, int timeout) {
        boolean flag = true;
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.MILLISECONDS);
        if (driver.findElements(locator).isEmpty()) {
            flag = false;
        }
        driver.manage().timeouts().implicitlyWait(ConfigValues.DEFAULT_COOLDOWN_FOR_DRIVER_MSEC, TimeUnit.MILLISECONDS);
        return flag;

    }

    public boolean isControlExistOnPage(By locator, int... timeout) {
        return isControlExistOnPage(locator, timeout[0]);
    }


    public void sleep(int timeMSec) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public WebElement waitTillElementClickable(By locator) {

        WebDriverWait waiter = new WebDriverWait(driver, ConfigValues.LONG_DELAY_SEC);
        return waiter.until(ExpectedConditions.elementToBeClickable(locator));

    }

    public WebElement waitTillElementLoaded(By locator) {

        WebDriverWait waiter = new WebDriverWait(driver, ConfigValues.LONG_DELAY_SEC);
        return waiter.until(ExpectedConditions.presenceOfElementLocated(locator));

    }


}
