package Resources;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Dmytro_Moskalenko2 on 10/8/2015.
 */
public class InputData {

private  HashMap<String,String> hashMapFilter = new HashMap<>();

    private List <Pair<String,String>> hashMapFilter1=new ArrayList<Pair<String, String>>();


    public HashMap<String, String> dataForFilter(){
        hashMapFilter= new HashMap<>();
        hashMapFilter.put("Brand", "Motorola");
        hashMapFilter.put("Condition","New");
        return hashMapFilter;
    }

    public List<Pair<String, String>> dataForFilter1(){

        //hashMapFilter1= new ArrayList();
        hashMapFilter1.add(new Pair("Brand", "Motorola"));
        return hashMapFilter1;
    }
}
