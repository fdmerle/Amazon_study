package calculator.main;

import calculator.actions.IActions;
import calculator.actions.Mult;
import calculator.actions.Sum;
import calculator.factory.ActionsFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
            return this.actionsList.get(opearationMath).returnValue(values[0],values);
        } else {
            throw new IllegalArgumentException();
        }


    }


    private void actionFactoryInit() {
        ActionsFactory actionHashMap = new ActionsFactory();
        this.actionsList = actionHashMap.returnActions();
    }

    public void test(){
        List<IActions> list = new ArrayList();
        list.add(new Mult());
        list.add(new Sum());






    }
}

