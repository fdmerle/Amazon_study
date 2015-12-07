package Test;

import Java.Calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */

public class CaclulatorTest {
    Calculator calcObj = new Calculator();

    @Test
    public void testSum() {

        Assert.assertEquals(calcObj.action("+",7,5), 12);

    }
    @Test
    public void testDeduct() {

        Assert.assertEquals(calcObj.action("-",7,5), 2);

    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegal() {

        Assert.assertEquals(calcObj.action("/",7,5), 12);

    }

}