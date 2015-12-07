package Test;

import Java.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */

public class CaclulatorTest {
    Calculator calcObj = new Calculator("+", 3, 4);

    @Test
    public void testSum() {

        Calculator calcObj = new Calculator("+", 3, 4);
        Assert.assertEquals(calcObj.action(), 7);
        calcObj = new Calculator("-", 3, 6);
        Assert.assertEquals(calcObj.action(), -3);

    }

    @Test
    public void testDeduct() {
        calcObj = new Calculator("-", 3, 6);
        Assert.assertEquals(calcObj.action(), -3);
    }

    @Test
    public void testIllegal() {
        calcObj = new Calculator("/", 3, 6);
        Assert.assertEquals(calcObj.action(), 000);
    }
}