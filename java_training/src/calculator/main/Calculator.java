package calculator.main;

import calculator.actions.IActions;
import calculator.factory.ActionsFactory;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/4/2015.
 */
public class Calculator {
    private HashMap<String, IActions> actionsList;

    public Calculator() {
        actionFactoryInit();
    }

    public int action(String opearationMath, int... values) {

        if (this.actionsList.containsKey(opearationMath)) {
            return this.actionsList.get(opearationMath).returnValue(values);
        } else {
            throw new IllegalArgumentException();
        }


    }


    private void actionFactoryInit() {
        ActionsFactory actionHashMap = new ActionsFactory();
        this.actionsList = actionHashMap.returnActions();
    }
}

