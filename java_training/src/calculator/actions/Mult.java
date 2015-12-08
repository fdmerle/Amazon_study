package calculator.actions;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class Mult implements IActions {

    public int returnValue(int... argList) {

        int i;
        int resultMult;
        if (argList.length == 0) {
            throw new IllegalArgumentException();
        }

        resultMult = argList[0];
        for (i = 1; i < argList.length; i++) {
            resultMult = resultMult * argList[i];

        }

        return resultMult;
    }
}
