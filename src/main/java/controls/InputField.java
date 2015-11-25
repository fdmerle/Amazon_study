package controls;

import org.openqa.selenium.WebElement;

public class InputField {

    public static boolean setInputField(WebElement inField, String valueToEnter) {

        boolean flag = false;
        inField.sendKeys(valueToEnter);
        for (int i = 0; i < 10; i++) {
            flag = inField.getAttribute("value").equals(valueToEnter);
            if (!flag) {
                inField.clear();
                inField.sendKeys(valueToEnter);
            } else {
                break;
            }
        }
        return flag;
    }


}
