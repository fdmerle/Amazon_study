package test.java.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.config.Initialize;
import test.java.pages.Amazon;

/**
 * Created by Dmytro_Moskalenko2 on 9/29/2015.
 */


public class AmazonTest {
    Initialize driver;
    Amazon amazonPage;

    @BeforeMethod
    public void setUp(){
        driver = new Initialize();
        amazonPage = new Amazon(driver.initialize());
    }


    @Test
    public void amazonTest() {
        String dataToInput = "Droid Turbo";
        amazonPage.inputValueToSearch(dataToInput);
        amazonPage.pressSubmit();
        amazonPage.clearInputField();
        amazonPage.changeCategofySerach("Electronics", "droid turbo");
        amazonPage.pressSubmit();

    }
}
