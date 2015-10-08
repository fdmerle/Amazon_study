import org.junit.Test;

/**
 * Created by Dmytro_Moskalenko2 on 10/8/2015.
 */
public class TestTest {

    private static class TEstModel{
        public int underTest;
    }

    private static class DOSomething{
        DOSomething(TEstModel a){
            a.underTest += 20;
        }
    }

    @Test
    public void testName() throws Exception {
        TEstModel a = new TEstModel();
        a.underTest = 10;

        System.out.println(a.underTest);

        DOSomething b = new DOSomething(a);

        System.out.println(a.underTest);
    }
}
