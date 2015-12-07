package Java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmytro_Moskalenko2 on 12/7/2015.
 */
public class CalcFactory {

    public List<Integer> returnAll(){
        List<Integer> results = new ArrayList<>();
        results.add(new Deduct().returnDeduct(10,15));
        results.add(new Mult().returnMult(10, 15));
        results.add(new Sum().returnSum(10,15));
        return results;
    }
}
