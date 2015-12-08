package Java;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/4/2015.
 */
public class Calculator {
    private HashMap<String, InterfaceCalc> calculatorObj;

    public int action(String opearation, int valFirst, int valSecond) {
        CalcFactory calculator = new CalcFactory();
        calculatorObj = calculator.returnCalc();
        if (calculatorObj.containsKey(opearation)) {
            return calculatorObj.get(opearation).returnValue(valFirst, valSecond);
        } else {
            throw new IllegalArgumentException();
        }





    }

}

