package Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by dmytro_moskalenko2 on 12/23/2015.
 */
public class ResponceUrlBuilder {
    private String serviceUrl = "http://api.openweathermap.org/data/2.5/weather?q=";
    private String serviceToken = "7e6c68e6843af56620fcd8e6a14d62b1";
    private String selectedCountry = "pl";
    private String dateForUrl;

    public String returnUrl(String requestCity, String requestDate) {
        dateForUrl = getDateString(requestDate);
        return serviceUrl+ requestCity + "," + selectedCountry + "&units=metric&APPID=" + serviceToken;
    }

    public String returnUrl(String requestDate) {
        dateForUrl = getDateString(requestDate);
        return null;
    }

    private String getDateString(String Date) {
        int divDate = 0;
        if (isDateValidFormat("MM/dd/yyyy", Date)) {
            return Date;
        } else {
            switch (Date) {
                case "Yesterday":
                    divDate = -1;
                    break;
                case "Today":
                    divDate = 0;
                    break;
                case "Tomorrow":
                    divDate = 1;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.DATE, divDate);
            return dateFormat.format(cal.getTime());
        }

    }

    public static boolean isDateValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }
}
