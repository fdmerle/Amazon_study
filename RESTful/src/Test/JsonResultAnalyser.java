package Test;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by dmytro_moskalenko2 on 12/23/2015.
 */
public class JsonResultAnalyser {
    private JSONObject obj;
    public String url;
    RespondSender respondSender = new RespondSender();
    private RespondUrlBuilder urlCreator = new RespondUrlBuilder();

    public void JsonResultInit(String jsonStringResult) {
        obj = new JSONObject(jsonStringResult);
    }


    public int parceCityData() {
        JSONObject result = obj.getJSONObject("main");
        return result.getInt("temp");

    }

    public List<WeatherObject> parcCitiesData() {
        int i;
        List<WeatherObject> respondObject = new ArrayList<>();
        JSONArray result = obj.getJSONArray("list");


        for (i = 0; i < result.length(); i++) {
            JSONObject cityResult = result.getJSONObject(i).getJSONObject("main");
            respondObject.add(new WeatherObject(result.getJSONObject(i).getString("name"), cityResult.getInt("temp_min")));
        }

        Collections.sort(respondObject, new WeatherObject());
        return respondObject;

    }

    public int getTemperature(String strCity, String strDate) {
        String weatherRespond = null;
        try {
            url = urlCreator.returnUrl(strCity, strDate);
            weatherRespond = respondSender.sendGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }


        JsonResultInit(weatherRespond);
        int result = parceCityData();
        System.out.println(result);
        return result;
    }

    public Object getWarmestCity(String strDate) {
        String weatherResponse = null;
        try {
            url = urlCreator.returnUrl(strDate);
            weatherResponse = respondSender.sendGet(url);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonResultInit(weatherResponse);
        List<WeatherObject> result = parcCitiesData();

        System.out.println(result.get(0).getCityName());



        return result.get(0).getCityName();

    }
}