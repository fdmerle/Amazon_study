package Test;

import org.testng.annotations.Test;

/**
 * Created by dmytro_moskalenko2 on 1/18/2016.
 */
public class TestSuite extends MainTest {

    @Test
    public void testRunner() {

        senderObject.getTemperature("Krakow", "Yesterday");
        senderObject.getTemperature("Gdansk", "Tomorrow");
        senderObject.getTemperature("Gdansk", "Today");
        senderObject.getTemperature("Wroclaw", "01/22/2016");

        senderObject.getWarmestCity("Yesterday");
        senderObject.getWarmestCity("Tomorrow");
        senderObject.getWarmestCity("Today");
        senderObject.getWarmestCity("01/22/2016");

    }
}
