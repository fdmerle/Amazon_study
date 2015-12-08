package calculator.main;

import calculator.factory.ActionsFactory;
import calculator.actions.IActions;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/4/2015.
 */
public class Calculator {
    private HashMap<String, IActions> calculatorObj;

    public int action(String opearationMath, int... values) {
        ActionsFactory actionHashMap = new ActionsFactory();
        this.calculatorObj = actionHashMap.returnActions();
        if (this.calculatorObj.containsKey(opearationMath)) {
            return this.calculatorObj.get(opearationMath).returnValue(values);
        } else {
            throw new IllegalArgumentException();
        }


    }

}

