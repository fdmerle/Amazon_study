package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

/**
 * Created by Dmytro_Moskalenko2 on 9/29/2015.
 */
public class AmazonPage extends Page {

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchField;
    @FindBy(id = "searchDropdownBox")
    private WebElement searchDropdownBox;
    @FindBy(xpath = ".//*[@id='nav-search']/form/div[2]/div/input")
    private WebElement searchButton;
    private WebElement filterGroup;
    private WebElement filterText;


    public void inputValue(String dateToInput) {
        searchField.sendKeys(dateToInput);
    }

    public void clearInputValue() {
        searchField.clear();
    }

    public void changeCategory(String categoryName) {
        searchDropdownBox.sendKeys(categoryName);
    }

    public void pressSubmit() {
        searchButton.click();
    }

    public void filterItemClick(Map<String, String> filterItem, WebDriver driver) {
        //WebElement rootFilterElement = driver.findElement(By.id("refinements"));
        String parentXpath=".//*[@id='refinements']";
        for (Map.Entry<String, String> entry : filterItem.entrySet()) {

            String xpathValue=parentXpath+"/h2[contains(.,'"+entry.getKey()+"')]/following::span[1][contains(.,'"+entry.getValue()+"')]";
            driverCooldown(driver,1);
            if (!driver.findElements(By.xpath(xpathValue)).isEmpty()){
                filterText = driver.findElement(By.xpath(xpathValue));
                filterText.click();
            }
            else
            {
                System.out.println("Menu wasn't found: Group: " + entry.getKey()+"; Value: "+entry.getValue());
            }
        }
        driverCooldown(driver,30);
    }
}