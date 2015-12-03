package pages;

import config.*;
import controls.InputField;
import javafx.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dmytro_Moskalenko2 on 9/29/2015.
 */
public class AmazonPage extends Page {

    // public static final String XPATH_FOR_MAIN_GOOD = ".//*[@id='result_%d']";
    public static final String CSS_FOR_MAIN_GOOD = "#result_%d";
    public static final String FILTER_PARENT_XPATH = ".//*[@id='refinements']";
    public static final String FILTER_PARENT_CSS = "#refinements";
    public static final String XPATH_FOR_PAGE_CONSOL = ".//*[@id='pagn']";
    //    public static final String XPATH_FOR_NEXT_PAGE = ".//*[@id='pagnNextString']";
    public static final String CSS_FOR_NEXT_PAGE = "#pagnNextString";
    //   public static final String XPATH_FOR_LAST_PAGE = ".//*[@class='srSprite lastPageRightArrow']";
    public static final String CSS_FOR_LAST_PAGE = "span[class='srSprite lastPageRightArrow']";
    //    public static final String XPATH_FOR_RESULT_LIST = ".//li[contains(@id,'result_')]";
    public static final String CSS_FOR_RESULT_LIST = "li[id^='result_']";


    //private String xpath_for_filter = FILTER_PARENT_XPATH + "/h2[contains(.,'%s')]/following::span[1][contains(.,'%s')]";

    private String css_for_filter = FILTER_PARENT_XPATH + "/h2[contains(.,'%s')]/following::span[1][contains(.,'%s')]";
    private String resultFirstXpath = ".//*[@id='result_0']//a/h2";
    private String resultFirstCss = "#result_0 a h2";
    //private String xpathDiscount = ".//span[contains(@class,' a-color-secondary a-text-strike')]";
    private String cssDiscount = "span[class^='a-size-small a-color-secondary a-text-strike']";
    //    private String xpathPrice = ".//span[contains(@class, 's-price a-text-bold' )]";
    private String cssPrice = "span[class^= 'a-size-base a-color-price s-price a-text-bold']";

    //private String xpathFeedbackAmount = ".//div//a[contains(@href,'customerReviews')]";
    private String cssFeedbackAmount = "div a[href^='customerReviews']";
    //private String xpathRaiting = ".//span[@class='a-declarative']//span[@class='a-icon-alt']";
    private String cssRaiting = "span[class='a-declarative'] span[class='a-icon-alt']";
    //@FindBy(id = "sort")
    @FindBy(css = "#sort")
    private WebElement relevantsDropDown;


    // @FindBy(xpath = ".//*[@id='twotabsearchtextbox']")
    @FindBy(css = "#twotabsearchtextbox")
    private WebElement searchField;
    //    @FindBy(id = "searchDropdownBox")
    @FindBy(css = "#searchDropdownBox")
    private WebElement searchDropdownBox;
    //    @FindBy(xpath = ".//*[@id='nav-search']/form/div[2]/div/input")
    @FindBy(css = "#nav-search form div input[value='Go'")
    private WebElement searchButton;
    //@FindBy(xpath = ".//*[@id='result_0']/")
    @FindBy(css = "#result_0")
    private WebElement resultFirst;
    private WebElement filterText;
    //private String linkXpath = "//a[@class='a-link-normal a-text-normal']";
    private String linkCSS = "a[class='a-link-normal a-text-normal']";


    public AmazonPage(DriverObject driver) {
        super.driver = driver;
    }

    public void openPage() {
        driver.getDriver().get("http://Amazon.com");
        InputField inputField = new InputField();


    }

    public void searchForGoods(String goodsName, String categoryName, String relevantsName) {

        InputField.setInputField(searchField, goodsName);
        new Select(searchDropdownBox).selectByVisibleText(categoryName);
        searchButton.click();
        String xPath = String.format(AmazonPage.CSS_FOR_MAIN_GOOD, 1);
        driver.waitTillElementClickable(By.cssSelector(xPath));
        new Select(relevantsDropDown).selectByVisibleText(relevantsName);
    }

    public void filterResult(List<Pair<String, String>> filterItem) {


        Pair<String, String> item;
        for (Iterator<Pair<String, String>> i = filterItem.iterator(); i.hasNext(); ) {

            item = i.next();
            String cssValue = String.format(css_for_filter, item.getKey(), item.getValue());
            filterText = driver.waitTillElementClickable(By.xpath(cssValue));

            filterText.click();
            driver.waitTillElementLoaded(By.xpath(FILTER_PARENT_XPATH));
        }
    }


    public void clickTheFirstResult() {
        List<WebElement> listOfAllObject = driver.getDriver().findElements(By.cssSelector(CSS_FOR_RESULT_LIST));
        listOfAllObject.get(0).click();
    }

    public String returnDiscount(WebElement parentElement) {

        String returnValue = "";
        List<WebElement> resultDiscount;
        resultDiscount = parentElement.findElements(By.cssSelector(cssDiscount));
        if (!resultDiscount.isEmpty()) {
            returnValue = resultDiscount.get(0).getText();
        }
        return returnValue;
    }

    public String returnPrice(WebElement parentElement) {
        String returnValue = "";
        List<WebElement> returnPrice;
        returnPrice = parentElement.findElements(By.cssSelector(cssPrice));
        if (!returnPrice.isEmpty()) {
            returnValue = returnPrice.get(0).getText();
        }
        return returnValue;
    }

    public int returnFeedbackAmount(WebElement parentElement) {
        String returnValue = "";
        List<WebElement> returnFeedback;
        returnFeedback = parentElement.findElements(By.cssSelector(cssFeedbackAmount));
        if (!returnFeedback.isEmpty()) {
            if (returnFeedback.get(0).getText().contains(",")) {
                returnValue = returnFeedback.get(0).getText().replace(",", "");
            } else if (returnFeedback.get(0).getText().isEmpty()) {
                returnValue = "0";
            } else {
                returnValue = returnFeedback.get(0).getText();
            }

        } else {
            returnValue = "0";
        }
        return Integer.parseInt(returnValue);
    }

    public String returnLink(WebElement parentElement) {

        return parentElement.findElements(By.cssSelector(linkCSS)).get(0).getAttribute("href");

    }


    public String returnRating(WebElement parentElement) {
        List<WebElement> listValue = parentElement.findElements(By.cssSelector(cssRaiting));
        String returbValue = "";
        if (!listValue.isEmpty()) {

            WebElement webElement = listValue.get(0);
            returbValue = webElement.getAttribute("innerHTML");

        }

        return returbValue;

    }

    public WebElement returnMainElement(int i) {
        return driver.findElement(By.cssSelector(String.format(CSS_FOR_MAIN_GOOD, i)));
    }

    public List returnListOfElement() {

        driver.waitTillElementClickable(By.cssSelector(String.format(CSS_FOR_MAIN_GOOD, 1)));
        List tmp = new ArrayList<>();

        while (!isPageLast()) {

            boolean result = tmp.addAll(returnList());
            driver.findElement(By.cssSelector(CSS_FOR_NEXT_PAGE)).click();
        }


        return tmp;

    }


    public List returnList() {
        List<WebElement> listOfAllObject;
        List<GoodsExemplar> resultlistOfObject = new ArrayList<GoodsExemplar>();

        listOfAllObject = driver.getDriver().findElements(By.cssSelector(CSS_FOR_RESULT_LIST));

        if (listOfAllObject.isEmpty()) {

            return listOfAllObject;

        } else {
            for (WebElement item : listOfAllObject) {
                GoodsExemplar goods = returnFilledModel(item);
                resultlistOfObject.add(goods);
            }
        }
        return resultlistOfObject;
    }


    public GoodsExemplar returnFilledModel(WebElement itemXpath) {

        GoodsExemplar returnExemplarItem;
        returnExemplarItem = new GoodsExemplar(returnDiscount(itemXpath), returnPrice(itemXpath), returnRating(itemXpath), returnFeedbackAmount(itemXpath), returnLink(itemXpath));
        return returnExemplarItem;
    }


    public boolean isPageLast() {

        return driver.isControlExistOnPage(By.cssSelector(CSS_FOR_LAST_PAGE), 100);
    }

}