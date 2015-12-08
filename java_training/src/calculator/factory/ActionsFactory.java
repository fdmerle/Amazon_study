package calculator.factory;

import calculator.actions.Deduct;
import calculator.actions.IActions;
import calculator.actions.Sum;
import calculator.actions.Mult;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class ActionsFactory {

    public HashMap<String, IActions> returnActions() {
        HashMap<String, IActions> actions = new HashMap<>();
        actions.put("+", getSumAction());
        actions.put("-", getDeductAction());
        actions.put("*", getMultAction());
        return actions;
    }

    private Sum getSumAction(){
        return new Sum();
    }

    private Deduct getDeductAction(){
        return new Deduct();
    }

    private Mult getMultAction(){
        return new Mult();
    }

}
