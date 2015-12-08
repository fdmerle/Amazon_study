package calculator.actions;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class Sum implements IActions {

    public int returnValue(int... argList) {

        int i;
        int resultSum;
        if (argList.length == 0) {
            throw new IllegalArgumentException();
        }

        resultSum = argList[0];
        for (i = 1; i < argList.length; i++) {
            resultSum = resultSum + argList[i];

        }

        return resultSum;
    }
}
