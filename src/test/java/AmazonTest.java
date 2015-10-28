import Resources.ImputData;
import org.testng.annotations.Test;
import pages.AmazonPage;

import java.util.List;

public class AmazonTest extends MainTest {
    private ImputData inputData;
    private AmazonPage amazonPage;


    @Test
    public void amazonTest() {

        initDriver("FireFox");
        amazonPage.openPage();
        amazonPage.searchForGoods("Droid Turbo", "Electronics", "Featured");
        amazonPage.filterItem(inputData.dataForFilter());
        amazonPage.waitWhenObjectAppeared();
        List tmpList = amazonPage.returnListOfElement();
        amazonPage.clickTheFirstResult();


    }
}