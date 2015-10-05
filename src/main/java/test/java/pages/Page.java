package test.java.pages;



import org.openqa.selenium.WebDriver;
import test.java.controls.*;
import java.util.ArrayList;


public abstract class Page {

    protected String URL;
    protected WebDriver driver;
    protected ArrayList<InputField> inputFields;
    protected ArrayList<Button> buttons;
    protected ArrayList<Link> links;
    protected ArrayList<DropDown> selectFields;

    protected Page(WebDriver driver) {
        this.driver = driver;
        inputFields = new ArrayList<InputField>();
        buttons = new ArrayList<Button>();
        selectFields = new ArrayList<DropDown>();
        addInputFields();
        addLinks();
        addSelectField();
    }


    protected void addInputFields() {
    }

    protected void addLinks() {
    }


    protected void addSelectField() {
    }


    public String getURL() {
        return URL;
    }

}