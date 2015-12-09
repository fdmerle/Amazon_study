package calculator.actions;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class Sum implements IActions {

    public int returnValue(int firstArg, int... argList) {

        int i;
        int resultSum;

        resultSum = firstArg;
        for (i = 1; i < argList.length; i++) {
            resultSum = resultSum + argList[i];

        }

        return resultSum;
    }
}
