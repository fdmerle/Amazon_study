package java.main;

import java.factory.CalcFactory;
import java.actions.InterfaceActions;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/4/2015.
 */
public class Calculator {
    private HashMap<String, InterfaceActions> calculatorObj;

    public int action(String opearationMath, int... values) {
        CalcFactory calculatorObj = new CalcFactory();
        this.calculatorObj = calculatorObj.returnCalc();
        if (this.calculatorObj.containsKey(opearationMath)) {
            return this.calculatorObj.get(opearationMath).returnValue(values);
        } else {
            throw new IllegalArgumentException();
        }


    }

}

