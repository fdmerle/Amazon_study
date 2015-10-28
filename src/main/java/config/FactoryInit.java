package config;

import org.openqa.selenium.support.PageFactory;
import pages.AmazonPage;

/**
 * Created by Dmytro_Moskalenko2 on 10/1/2015.
 */
public class FactoryInit {


    public AmazonPage createPageFactory(DriverObject driver) {
        AmazonPage amazonPage = new AmazonPage(driver);
        PageFactory.initElements(driver.getDriver(), amazonPage);
        return amazonPage;

    }
}