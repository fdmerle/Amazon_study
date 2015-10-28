package pages;

import config.DriverObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Dmytro_Moskalenko2 on 10/5/2015.
 */
public abstract class Page {

    DriverObject driver;

    public Page (DriverObject driver) {
        this.driver = driver;
    }
    public void inputValue(String dateToInputm, WebElement searchField) {
        searchField.sendKeys(dateToInputm);
    }

    public void clearInputValue(WebElement searchField) {
        searchField.clear();
    }

    public void changeCategory(String categoryName,WebElement searchDropdownBox) {
        Select dropDown=new Select(searchDropdownBox);
        dropDown.selectByVisibleText(categoryName);
    }

    public void pressSubmit(WebElement searchButton) {
        searchButton.click();
    }








}
