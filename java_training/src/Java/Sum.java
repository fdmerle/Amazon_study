package Java;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class Sum implements InterfaceCalc {

    public int returnValue(int... intValues) {

        int i;
        int resultDeduct;
        if (intValues.length == 0) {
            throw new IllegalArgumentException();
        }

        resultDeduct = intValues[0];
        for (i = 1; i < intValues.length; i++) {
            resultDeduct = resultDeduct + intValues[i];

        }

        return resultDeduct;
    }
}
