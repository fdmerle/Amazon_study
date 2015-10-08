package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.AmazonPage;

/**
 * Created by Dmytro_Moskalenko2 on 10/1/2015.
 */
public class Initialize {


    public AmazonPage initialize(AmazonPage amazonPage, WebDriver driver) {
         amazonPage = PageFactory.initElements(driver, AmazonPage.class);
        return amazonPage;

    }
}