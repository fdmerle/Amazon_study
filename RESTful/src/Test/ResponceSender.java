package Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;


/**
 * Created by dmytro_moskalenko2 on 12/22/2015.
 */
public class ResponceSender {
    private final String USER_AGENT = "Mozilla/5.0";

    private String sendGet(String... temperData) throws Exception {
        ResponceUrlBuilder urlCreator = new ResponceUrlBuilder();
        String url=null;
        if (temperData.length>1){
            url = urlCreator.returnUrl(temperData[0], temperData[1]);
        }
        else{
            url = urlCreator.returnUrl(temperData[0]);
        }
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.toString();
    }
    public int getTemperature(String strCity,String strDate){
        String weatherResponce = null;
        try {
            weatherResponce=sendGet(strCity, strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JsonResultAnalyser resultAnalyser = new JsonResultAnalyser(weatherResponce);
        int result = resultAnalyser.parceCityData();
        System.out.println(result);
        return result;
    }
    public Object getWarmestCity(String strDate){
        String weatherResponce = null;
        try {
            weatherResponce=sendGet(strDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JsonResultAnalyser resultAnalyser = new JsonResultAnalyser(weatherResponce);
        Map<String, Integer> result = resultAnalyser.parceCitiesData();
        Iterator iter = result.keySet().iterator();

        System.out.println(iter.next());
        return iter.next();

    }

    }
