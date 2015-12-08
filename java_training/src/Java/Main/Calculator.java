package Java.Main;

import Java.Factory.CalcFactory;
import Java.Interfaces.InterfaceCalc;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/4/2015.
 */
public class Calculator {
    private HashMap<String, InterfaceCalc> calculatorObj;

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

