package Java;

/**
 * Created by Dmytro_Moskalenko2 on 12/4/2015.
 */
public class Calculator {


    public int action(String opearation, int valFirst, int valSecond) {
        int resVal;
        switch (opearation) {
            case "+":
                return valFirst + valSecond;

            case "-":
                return valFirst - valSecond;

            default:
                throw new IllegalArgumentException();

        }

    }
}
