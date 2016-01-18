package Test;

import java.util.Comparator;
import java.util.Map;

public class MyComparator implements Comparator<Map.Entry<String, Integer>> {


    private boolean order;

    public MyComparator(boolean order) {
        this.order = order;
    }

    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

        if (order)
        {
            return o1.getValue().compareTo(o2.getValue());
        }
        else
        {
            return o2.getValue().compareTo(o1.getValue());

        }
    }
}