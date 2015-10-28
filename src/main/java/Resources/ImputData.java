package Resources;

import java.util.HashMap;

/**
 * Created by Dmytro_Moskalenko2 on 10/8/2015.
 */
public class ImputData {

private  HashMap<String,String> hashMapFilter = new HashMap<>();

    public HashMap<String, String> dataForFilter(){
        hashMapFilter= new HashMap<>();
        hashMapFilter.put("Brand", "Motorola");
        hashMapFilter.put("Condition","New");
        return hashMapFilter;
    }

}
