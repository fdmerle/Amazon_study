package config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmytro_moskalenko2 on 10/21/2015.
 */
public class DriverObject{
private WebDriver driver;


    public void pageInit(String browserType){
        switch (browserType){
            case "FireFox":
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myProfile = profile.getProfile("automation");
        driver = new FirefoxDriver(myProfile);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }
    }

    public void controlCooldown(int intCooldown) {
        driver.manage().timeouts().implicitlyWait(intCooldown, TimeUnit.SECONDS);
    }
    public void pageCooldown( int intCooldown){
        driver.manage().timeouts().pageLoadTimeout(intCooldown, TimeUnit.SECONDS);
    }

public void sleep(int timeMSec){
    try {
        Thread.sleep(5000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

}

    public void get(String s) {
        driver.get(s);
    }

    public List<WebElement> findElements(By xpath) {
        return driver.findElements(xpath);
    }

    public WebElement findElement(By xpath) {
        return driver.findElement(xpath);
    }

    public WebDriver getDriver(){
        return driver;
    }


    /*   public void  doWithChangedTimeout(Action action, int timeout){

    }*/
}
