package pages;

import config.DriverObject;
import config.ReturnListOfElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

/**
 * Created by Dmytro_Moskalenko2 on 9/29/2015.
 */
public class AmazonPage extends Page {

    public static final String XPATH_FOR_MAIN_GOOD = ".//*[@id='result_%d']";
    private String parentXpath = ".//*[@id='refinements']";
    private String XPATH_FOR_FILTER = parentXpath + "/h2[contains(.,'$a')]/following::span[1][contains(.,'$b')]";
    private String resultFirstXpath = ".//*[@id='result_0']//a/h2";
    private String xpathDiscount = "//span[@class='a-size-small a-color-secondary a-text-strike']";
    private String xpathDiscoundReturn = "//span[@class='a-size-small a-color-secondary a-text-strike']";
    private String xpathPrice = "//div[@class='a-row a-spacing-none'][1]//span[contains(@class , 'a-size-base a-color')]";
    private String xpathFeedbackAmount = "/div[@class='s-item-container']/div[last()]/a[@class='a-size-small a-link-normal a-text-normal']";
    private String xpathRaiting = "//span[@class='a-declarative']//span[@class='a-icon-alt']";
    @FindBy(id = "sort")
    private WebElement relevantsDropDown;
    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;
    @FindBy(id = "searchDropdownBox")
    private WebElement searchDropdownBox;
    @FindBy(xpath = ".//*[@id='nav-search']/form/div[2]/div/input")
    private WebElement searchButton;
    @FindBy(xpath = ".//*[@id='result_0']/")
    private WebElement resultFirst;
    private WebElement filterText;

    public AmazonPage(DriverObject driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("http://Amazon.com");
    }

    public void searchForGoods(String goodsName, String categoryName, String relevantsName) {
        inputValue(goodsName, searchField);
        changeCategory(categoryName, searchDropdownBox);
        pressSubmit(searchButton);
        changeCategory(relevantsName, relevantsDropDown);
    }

    public void filterItem(Map<String, String> filterItem) {




// filterItem.entrySet().foreach(function)
// in function:



        for (Map.Entry<String, String> entry : filterItem.entrySet()) {
            driver.sleep(5000);
            driver.controlCooldown(3);
            String xpathValue = String.format(XPATH_FOR_FILTER, entry.getKey(), entry.getValue());
            if (!driver.findElements(By.xpath(xpathValue)).isEmpty()) {
                filterText = driver.findElement(By.xpath(xpathValue));
                filterText.click();
            } else {
                System.out.println("Menu wasn't found: Group: " + entry.getKey() + "; Value: " + entry.getValue());
            }
        }
    }

    public void clickTheFirstResult() {
        driver.sleep(5000);
        driver.findElement(By.xpath(resultFirstXpath)).click();
    }

    public String returnDiscount(int i) {

        String returnValue = "";
        String xPath = String.format(XPATH_FOR_MAIN_GOOD, i) + xpathDiscount;

        if (driver.findElements(By.xpath(xPath)).isEmpty()) {
            returnValue = null;
        } else {

            returnValue = driver.findElement(By.xpath(String.format(XPATH_FOR_MAIN_GOOD, i) + xpathDiscoundReturn)).getText();
        }


        return returnValue;
    }

    public String returnPrice(int i) {
        return driver.findElement(By.xpath(String.format(XPATH_FOR_MAIN_GOOD, i) + xpathPrice)).getText();
    }

    public int returnFeedbackAmount(int i) {
        String strFeedback = driver.findElement(By.xpath(String.format(XPATH_FOR_MAIN_GOOD, i) + xpathFeedbackAmount)).getText();
        if (strFeedback.contains(",")) {
            strFeedback = strFeedback.replace(",", "");
        }
        return Integer.parseInt(strFeedback);
    }



    public String strRating(int i) {
        return driver.findElement(By.xpath(String.format(XPATH_FOR_MAIN_GOOD, i) + xpathRaiting)).getText();

    }

    public WebElement returnMainElement(int i) {
        return driver.findElement(By.xpath(String.format(AmazonPage.XPATH_FOR_MAIN_GOOD, i)));
    }

    public List returnListOfElement() {
        return new ReturnListOfElements().returnList(this);
    }

    public void waitWhenObjectAppeared() {
        driver.controlCooldown(3);


        for (int i = 0; i < 30; i++) {

            if (!driver.findElements(By.xpath(String.format(AmazonPage.XPATH_FOR_MAIN_GOOD, i))).isEmpty()) {
                break;
            }


            System.out.println("There is no Goods list on the page");
        }
    }
}