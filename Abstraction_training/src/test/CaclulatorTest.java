package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import calculator.main.Calculator;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */

public class CaclulatorTest {
    Calculator calcObj = new Calculator();

    @Test
    public void testSum() {

        Assert.assertEquals(calcObj.action("+", 7, 5), 12);

    }

    @Test
    public void testDeduct() {

        Assert.assertEquals(calcObj.action("-", 7, 5), 2);

    }

    @Test
    public void testMult() {

        Assert.assertEquals(calcObj.action("*", 7, 5), 35);

    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testIllegal() {

        Assert.assertEquals(calcObj.action("/", 7, 5), 12);

    }

}