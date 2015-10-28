package config;

import pages.AmazonPage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmytro_moskalenko2 on 10/15/2015.
 */


public class ReturnListOfElements {

    private List returnListOfObject;
    private int i;

    private GrabGoodsData modelElement;
    private GoodsExemplar modelItem;

    public ReturnListOfElements() {
        i = 0;
        modelElement=new GrabGoodsData();
    }

    public List returnList(AmazonPage amazonPage) {
        returnListOfObject = new ArrayList<GoodsExemplar>();
        while (amazonPage.returnMainElement(i).isDisplayed()) {
            modelItem=modelElement.returnFilledModel(amazonPage,i);
            returnListOfObject.add(modelItem);
            if (i == 20) {
                System.out.println("warning");
            }
            i++;
        }


        return returnListOfObject;
    }


}
