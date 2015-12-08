package Java;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class CalcFactory {

    public HashMap<String, InterfaceCalc> returnCalc() {
        HashMap<String, InterfaceCalc> calculatorObj = new HashMap<>();
        calculatorObj.put("+", new Sum());
        calculatorObj.put("-", new Deduct());
        calculatorObj.put("*", new Mult());
        return calculatorObj;
    }
}