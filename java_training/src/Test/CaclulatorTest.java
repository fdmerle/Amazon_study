package Test;

import Java.CalcFactory;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */

public class CaclulatorTest {

    CalcFactory calculator=new CalcFactory();

    @Test
    public void testSum() {
        List<Integer> resList=calculator.returnAll();
        resList.forEach(System.out::println);
    }
//    @Test
//    public void testDeduct() {
//
//        Assert.assertEquals(calcObj.action("-",7,5), 2);
//
//    }
//    @Test(expectedExceptions = IllegalArgumentException.class)
//    public void testIllegal() {
//
//        Assert.assertEquals(calcObj.action("/",7,5), 12);
//
//    }

}