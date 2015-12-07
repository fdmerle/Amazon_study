package Java;

/**
 * Created by Dmytro_Moskalenko2 on 12/4/2015.
 */
public class calculator {
    private int valFirst;
    private int valSecond;
    private String opearation = "";

    public calculator(String oper1, int val1, int val2) {
        opearation = oper1;
        valFirst=val1;
        valSecond=val2;

    }

    public int action() {
        int resVal;
        switch (opearation) {
            case "+":
                resVal=valFirst + valSecond;
                break;
            case "-":
                resVal=valFirst - valSecond;
                break;
            default:
                System.out.println("invalid operator");
                resVal=000;
                break;
        }
        return resVal;

    }
}
