package config;

import java.util.Date;

/**
 * Created by Dmytro_Moskalenko2 on 10/14/2015.
 */
public class GoodsExemplar {
    private String strDiscount;
    private String strPrice;
    private String strRating;
    private int strFeedbackAmount;
    private Date expiration;
    private String strLink;


    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    public GoodsExemplar(String strDiscount, String strPrice, String strRating, int strFeedbackAmount, String strLink) {
        this.strDiscount = strDiscount;
        this.strPrice = strPrice;
        this.strRating = strRating;
        this.strFeedbackAmount = strFeedbackAmount;
        this.strLink = strLink;

    }

    public String getStrDiscount() {
        return strDiscount;
    }

    public String getStrPrice() {
        return strPrice;
    }

    public String getStrRating() {
        return strRating;
    }

    public int getStrFeedbackAmount() {
        return strFeedbackAmount;
    }
}


