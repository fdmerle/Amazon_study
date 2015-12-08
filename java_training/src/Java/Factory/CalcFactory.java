package java.factory;

import java.actions.Deduct;
import java.actions.InterfaceCalc;
import java.actions.Mult;
import java.actions.Sum;

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
