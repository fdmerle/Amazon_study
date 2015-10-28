package config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.AmazonPage;

/**
 * Created by dmytro_moskalenko2 on 10/15/2015.
 */
public class GrabGoodsData {
    private WebElement mainItemXpath;
    private WebDriver driverForSort;
    private GoodsExemplar returnExemplarItem;
    public GoodsExemplar returnFilledModel(AmazonPage pageElement, int itemXpath) {
        mainItemXpath = pageElement.returnMainElement(itemXpath);
        returnExemplarItem = new GoodsExemplar(pageElement.returnDiscount(itemXpath), pageElement.returnPrice(itemXpath), pageElement.strRating(itemXpath), pageElement.returnFeedbackAmount(itemXpath));
        return returnExemplarItem;
    }
}
