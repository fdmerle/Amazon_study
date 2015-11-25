package tmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmytro_moskalenko2 on 10/21/2015.
 */
public class DriverObject extends RemoteWebDriver{
    private WebDriver driver;
    public static final int defaultCooldownForDriver = 20;

    public void pageInit(String browserType) {
        switch (browserType) {
            case "FireFox":
                ProfilesIni profile = new ProfilesIni();
                FirefoxProfile myProfile = profile.getProfile("automation");
                driver = new FirefoxDriver(myProfile);
                driver.manage().timeouts().implicitlyWait(defaultCooldownForDriver, TimeUnit.SECONDS);
        }
    }

    private boolean isControlExistOnPage(By locator, int timeout) {
        boolean flag = true;
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if (driver.findElements(locator).isEmpty()) {
            flag = false;
        }
        driver.manage().timeouts().implicitlyWait(defaultCooldownForDriver, TimeUnit.SECONDS);
        return flag;

    }

    public boolean isControlExistOnPage(String xPath, int... timeout) {
        return isControlExistOnPage(By.xpath(xPath), timeout[0]);
    }


    public void sleep(int timeMSec) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void get(String url) {
        driver.get(url);
    }

    public List<WebElement> findElements(By xpath) {
        return driver.findElements(xpath);
    }

    public WebElement findElement(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement waitTillElementClickable(String locator, int coolDown) {

        WebDriverWait waiter = new WebDriverWait(driver, coolDown);
        return waiter.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

    }

    public WebElement waitTillElementLoaded(String locator, int coolDown) {

        WebDriverWait waiter = new WebDriverWait(driver, coolDown);
        return waiter.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));

    }


}
