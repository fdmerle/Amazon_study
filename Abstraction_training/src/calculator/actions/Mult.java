package calculator.actions;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class Mult implements IActions {

    public int returnValue(int firstArg, int... argList) {

        int i;
        int resultMult;

        resultMult = firstArg;
        for (i = 1; i < argList.length; i++) {
            resultMult = resultMult * argList[i];

        }

        return resultMult;
    }
}
