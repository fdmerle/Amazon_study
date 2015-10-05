import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GoogleSearchPage {
    // The element is now looked up using the name attribute,
    // and we never look it up once it has been used the first time
    @FindBy(how = How.NAME, using = "q")
    @CacheLookup
    private WebElement searchBox;

    public void searchFor(String text) {
        // We continue using the element just as before
        searchBox.sendKeys(text);
        searchBox.submit();
    }
} 