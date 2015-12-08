package Java;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class CalcFactory {

    public HashMap<String,InterfaceCalc> returnCalc(){
        HashMap<String,InterfaceCalc> results = new HashMap<>();
        results.put("+", new Sum());
        results.put("-", new Deduct());
        results.put("*", new Sum());
        return results;
    }
}
