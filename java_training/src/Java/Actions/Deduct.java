package Java.Actions;

import Java.Interfaces.InterfaceCalc;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class Deduct implements InterfaceCalc {

    public int returnValue(int... argValues) {
        int i;
        int resultDeduct;
        if (argValues.length == 0) {
            throw new IllegalArgumentException();
        }

        resultDeduct = argValues[0];
        for (i = 1; i < argValues.length; i++) {
            resultDeduct = resultDeduct - argValues[i];

        }

        return resultDeduct;
    }


}


