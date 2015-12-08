package calculator.actions;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class Deduct implements IActions {

    public int returnValue(int... argList) {
        int i;
        int resultDeduct;
        if (argList.length == 0) {
            throw new IllegalArgumentException();
        }

        resultDeduct = argList[0];
        for (i = 1; i < argList.length; i++) {
            resultDeduct = resultDeduct - argList[i];

        }

        return resultDeduct;
    }


}


