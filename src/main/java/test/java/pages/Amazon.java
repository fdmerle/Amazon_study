package test.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.java.config.Initialize;
import test.java.controls.Button;
import test.java.controls.DropDown;
import test.java.controls.InputField;

/**
 * Created by Dmytro_Moskalenko2 on 9/29/2015.
 */
public class Amazon extends Page {
    private By searchField = By.id("twotabsearchtextbox");
    private By searchDropdownBox = By.id("searchDropdownBox");
    private By searchButton = By.xpath(".//*[@id='nav-search']/form/div[2]/div/input");


    public Amazon(WebDriver driver) {
        super(driver);
    //    init();

    }

    private void inputValue(By Element, String dateToInput) {
        InputField inputField = new InputField(driver, Element);
        inputField.setInputField(Element, dateToInput);
    }

    private void changeCategory(By Element, String categoryName) {
        DropDown dropDownField = new DropDown(driver, Element);
        dropDownField.setSelectField(Element, categoryName);
    }

    private void pressSubmit(By Element) {
        Button buttonToSubmit = new Button(driver, Element);
        buttonToSubmit.click(Element);
    }



    public void inputValueToSearch(String dataToInput){
        inputValue(searchField, dataToInput);
    }

    public void changeCategofySerach(String categoryName, String dataToInput){
        changeCategory(searchDropdownBox, categoryName);
        inputValueToSearch(dataToInput);
    }

    public void pressSubmit(){
        pressSubmit(searchButton);
    }

    public void clearInputField(){
        InputField inputField = new InputField(driver, searchField);
        inputField.Clear(searchField);
    }
    private WebDriver init(){
        Initialize amazonDriver=new Initialize();
        return amazonDriver.initialize();
    }

}
