import config.Initialize;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.AmazonPage;

import java.util.HashMap;

public class AmazonTest {

    Initialize initDriver;
    private HashMap <String,String> filterDictionary;
    /*@BeforeMethod
    public void setUp() {

    }*/


    @Test
    public void amazonTest(){
        AmazonPage amazonPageInit=new AmazonPage();
        WebDriver amazonDriver=amazonPageInit.pageInit("http://AmazonPage.com");
        initDriver = new Initialize();
        AmazonPage amazonPageFactory = initDriver.initialize(amazonPageInit,amazonDriver);

        String dataToInput = "Droid Turbo";

        amazonPageFactory.changeCategory("Electronics");
        amazonPageFactory.inputValue(dataToInput);
        amazonPageFactory.pressSubmit();

        filterDictionary= new HashMap<>();
        filterDictionary.put("Brand","Motorola");
        filterDictionary.put("Condition","New");
        amazonPageInit.filterItemClick(filterDictionary,amazonDriver);




    }
/*    @AfterMethod
    public void cleaner(){
        amazonPage.closeWindow();
    }*/
}
