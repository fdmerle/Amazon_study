package java.actions;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class Sum implements InterfaceCalc {

    public int returnValue(int... argValues) {

        int i;
        int resultSum;
        if (argValues.length == 0) {
            throw new IllegalArgumentException();
        }

        resultSum = argValues[0];
        for (i = 1; i < argValues.length; i++) {
            resultSum = resultSum + argValues[i];

        }

        return resultSum;
    }
}
