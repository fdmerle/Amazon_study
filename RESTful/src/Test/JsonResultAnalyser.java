package Test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

/**
 * Created by dmytro_moskalenko2 on 12/23/2015.
 */
public class JsonResultAnalyser {
    private JSONObject obj;

    JsonResultAnalyser(String jsonStringResult) {
        obj = new JSONObject(jsonStringResult);
    }


    public int parceCityData() {
        JSONObject result = obj.getJSONObject("main");
        return result.getInt("temp");

    }

    public Map<String, Integer> parceCitiesData() {
        int i;
        LinkedHashMap<String, Integer> objectObjectHashMap = new LinkedHashMap<>();
        Map<String, Integer> sortedObjectHashMap = new LinkedHashMap<>();
        JSONArray result = obj.getJSONArray("list");


        for (i = 0; i < result.length(); i++) {
            JSONObject cityResult = result.getJSONObject(i).getJSONObject("main");
            objectObjectHashMap.put(result.getJSONObject(i).getString("name"), cityResult.getInt("temp_min"));
        }

        sortedObjectHashMap = sortByComparator(objectObjectHashMap, false);

        return sortedObjectHashMap;


    }


    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order) {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new MyComparator(order));

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }


}