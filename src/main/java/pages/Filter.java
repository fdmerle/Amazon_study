package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;


/**
 * Created by Dmytro_Moskalenko2 on 10/5/2015.
 */
public class Filter extends Page {
    private int i;
    private WebElement filterGroup;
    private WebElement filterText;


    public void filterItemClick(HashMap<String,String> filterItem, AmazonPage amazonPage) throws InterruptedException {

        for (i=0;i<filterItem.size();i++){

           filterGroup= amazonPage.driver.findElement(By.xpath("//h2[contains(.,'International Shipping')]"));
           filterText = filterGroup.findElement(By.xpath("//h2[contains(.,'International Shipping')]"));
           filterText.click();
            wait(5);
        }
    }



}
