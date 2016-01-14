package Test;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by dmytro_moskalenko2 on 12/23/2015.
 */
public class JsonResultAnalyser {

    public String JsonResponceParser(String jsonStringResult){

        JSONObject obj = new JSONObject(jsonStringResult);
        //String pageName = obj.getJSONObject(jsonStringResult).getString("pageName");

        JSONArray arr = obj.getJSONArray("main");
        for (int i = 0; i < arr.length(); i++)
        {
            String post_id = arr.getJSONObject(i).getString("post_id");
        }

        return null;

    }



}
