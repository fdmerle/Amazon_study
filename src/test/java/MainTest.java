import Resources.ImputData;
import config.DriverInitialize;
import config.DriverObject;
import config.FactoryInit;
import pages.AmazonPage;

/**
 * Created by Dmytro_Moskalenko2 on 10/27/2015.
 */
public class MainTest {
    private DriverObject driver;
    private ImputData inputData;
    private AmazonPage amazonPage;
    public AmazonPage pageFactoryCreation() {

        FactoryInit initDriver = new FactoryInit();
        return initDriver.createPageFactory(driver);
    }

    public void initDriver(String browserType) {

        driver = new DriverInitialize().returnFireFoxDriverObject();
        driver.pageInit(browserType);
        inputData = new ImputData();
        amazonPage = pageFactoryCreation();

    }
}
