package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;

import java.util.concurrent.TimeUnit;


public abstract class Page {

    public WebDriver driver;


   public WebDriver pageInit(String URL){
       driver = new FirefoxDriver();
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get(URL);
       return driver;
   }

    public void driverCooldown(WebDriver driver, int intCooldown){
        driver.manage().timeouts().implicitlyWait(intCooldown, TimeUnit.SECONDS);
    }

   public void  doWithChangedTimeout(Action action, int timeout){

    }




}