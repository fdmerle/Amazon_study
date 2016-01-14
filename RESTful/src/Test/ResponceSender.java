package Test;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by dmytro_moskalenko2 on 12/22/2015.
 */
public class ResponceSender {
    private final String USER_AGENT = "Mozilla/5.0";

    @Test
    public void sendGet() throws Exception {

        ResponceUrlBuilder urlCreator = new ResponceUrlBuilder();
        String url = urlCreator.returnUrl("Krakow", "Yesterday");


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
        System.out.println(response.toString());
        JsonResultAnalyser resultAnalyser=new JsonResultAnalyser();
        resultAnalyser.JsonResponceParser(response.toString());

    }
}
