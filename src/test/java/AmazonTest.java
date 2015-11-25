import Resources.InputData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
        import pages.AmazonPage;

        import java.util.List;

public class AmazonTest extends MainTest {
    private InputData inputData;

    @Test
    public void amazonTest() {


        amazonPage.searchForGoods("Droid Turbo", "Electronics", "Featured");
        inputData = new InputData();
        amazonPage.filterResult(inputData.dataForFilter1());
        String xPath = String.format(AmazonPage.CSS_FOR_MAIN_GOOD, 1);
        driver.waitTillElementLoaded(By.cssSelector(xPath));
        List tmpList = amazonPage.returnListOfElement();
        amazonPage.clickTheFirstResult();


    }
}