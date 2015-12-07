package Test;

import Java.calculator;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */

public class UnitTest {
    calculator calcObj = new calculator("+",3,4);

    @Test
    public void testRun() {

        calculator calcObj = new calculator("+",3,4);
        Assert.assertEquals(calcObj.action(), 7);
        calcObj = new calculator("-",3,6);
        Assert.assertEquals(calcObj.action(), -3);

    }
}