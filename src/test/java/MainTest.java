import Resources.ConfigValues;
import config.DriverObject;
import config.FactoryInit;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pages.AmazonPage;

import java.util.List;

/**
 * Created by Dmytro_Moskalenko2 on 10/27/2015.
 */
public class MainTest extends TestListenerAdapter {
    public DriverObject driver;
    public AmazonPage amazonPage;

    public AmazonPage pageFactoryCreation() {

        FactoryInit initDriver = new FactoryInit();
        return initDriver.createPageFactory(driver);
    }

    public AmazonPage initDriver(String browserType) {

        driver = new DriverObject();

        driver.pageInit(browserType, "Grid");


        amazonPage = pageFactoryCreation();
        return amazonPage;

    }

    @BeforeTest
    public void initializerAmazonFireFox() {
        AmazonPage amazonPage = initDriver(ConfigValues.BROWSER_TYPE);
        amazonPage.openPage();
    }

    @AfterTest
    public void failedTestWrapper() {

        List tmp = getPassedTests();

        tmp = getFailedTests();
        getAllTestMethods();
    }

}
