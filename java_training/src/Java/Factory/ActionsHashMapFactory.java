package java.factory;

import java.actions.Deduct;
import java.actions.InterfaceActions;
import java.actions.Mult;
import java.actions.Sum;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class ActionsHashMapFactory {

    public HashMap<String, InterfaceActions> returnCalc() {
        HashMap<String, InterfaceActions> actionsHashMap = new HashMap<>();
        actionsHashMap.put("+", new Sum());
        actionsHashMap.put("-", new Deduct());
        actionsHashMap.put("*", new Mult());
        return actionsHashMap;
    }
}
