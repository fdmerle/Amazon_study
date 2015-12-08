package Java.Actions;

import Java.Interfaces.InterfaceCalc;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class Mult implements InterfaceCalc {

    public int returnValue(int... argValues) {

        int i;
        int resultMult;
        if (argValues.length == 0) {
            throw new IllegalArgumentException();
        }

        resultMult = argValues[0];
        for (i = 1; i < argValues.length; i++) {
            resultMult = resultMult * argValues[i];

        }

        return resultMult;
    }
}
