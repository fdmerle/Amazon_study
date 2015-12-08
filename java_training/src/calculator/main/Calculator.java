package calculator.main;

import calculator.actions.IActions;
import calculator.factory.ActionsFactory;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/4/2015.
 */
public class Calculator {
    private HashMap<String, IActions> calculatorObj;

    public Calculator() {
        CationFactoryInit();
    }

    public int action(String opearationMath, int... values) {

        if (this.calculatorObj.containsKey(opearationMath)) {
            return this.calculatorObj.get(opearationMath).returnValue(values);
        } else {
            throw new IllegalArgumentException();
        }


    }


    private void CationFactoryInit() {
        ActionsFactory actionHashMap = new ActionsFactory();
        this.calculatorObj = actionHashMap.returnActions();
    }
}

