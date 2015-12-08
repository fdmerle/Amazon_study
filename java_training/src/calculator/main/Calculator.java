package calculator.main;

import calculator.factory.ActionsFactory;

/**
 * Created by Dmytro_Moskalenko2 on 12/4/2015.
 */
public class Calculator {

    public int action(String opearationMath, int... values) {
        ActionsFactory actionHashMap = new ActionsFactory();

        if (actionHashMap.returnActions().containsKey(opearationMath)) {
            return actionHashMap.returnActions().get(opearationMath).returnValue(values);
        } else {
            throw new IllegalArgumentException();
        }


    }

}

