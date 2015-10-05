package factory_test.src;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class UsingGoogleSearchPage {

    @Test
    public static void main() {
        WebDriver driver;
        // Create a new instance of a driver
        driver = new FirefoxDriver();

        // Navigate to the right place
        driver.get("http://www.google.com/");

        // Create a new instance of the search page class
        // and initialise any WebElement fields in it.
        GoogleSearchPage page = PageFactory.initElements(driver, GoogleSearchPage.class);

        // And now do the search.
        page.searchFor("Cheese");
    }
} 