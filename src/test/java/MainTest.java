import config.DriverObject;
import config.FactoryInit;
import org.testng.annotations.BeforeTest;
import pages.AmazonPage;

/**
 * Created by Dmytro_Moskalenko2 on 10/27/2015.
 */
public class MainTest {
    public DriverObject driver;
    public AmazonPage amazonPage;
    public AmazonPage pageFactoryCreation() {

        FactoryInit initDriver = new FactoryInit();
        return initDriver.createPageFactory(driver);
    }

    public AmazonPage initDriver(String browserType) {

        driver = new DriverObject();
        driver.pageInit(browserType);
        amazonPage = pageFactoryCreation();
        return amazonPage;

    }

    @BeforeTest
    public void initializerAmazonFireFox(){
        AmazonPage amazonPage = initDriver("Chrome");
        amazonPage.openPage();
    }

}
