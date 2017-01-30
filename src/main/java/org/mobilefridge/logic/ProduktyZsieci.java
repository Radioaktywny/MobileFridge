/*
 * Copyright (c) Marcin Witek 2016 / 2017
 * Engineering project for studies on Cracow university of technology
 */

package org.mobilefridge.logic;

import org.json.JSONException;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.print.Doc;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by cos on 24.01.2017.
 */
public class ProduktyZsieci {
    public static JSONObject getJsonFromProduktyZsieci(String barcode)
    { JSONObject json=null;
        Document doc = null;
       // System.err.println("WPISAL TYP:" + barcode);
        try {
            doc = Jsoup.connect("http://www.produktywsieci.pl/gtin/"+barcode).timeout(100000).get();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
     //   System.err.println("Mam stronke");
        // System.out.println(doc.getElementsByClass("product-information-container" ));
        Elements productBasicInformation = doc.getElementsByClass("product-information-container");//System.out.println("\n \n");
        Elements productPics = doc.getElementsByClass("product-photo");
        try {
            json = new JSONObject(getNameAndGTIN(productBasicInformation.text()));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String [] tab = getPicsUrl(productBasicInformation.select("a").first() , barcode);
        try {
            json.put("IconBig", tab[0]);
            json.put("IconSmall", tab[1]);
            if(!json.getString("gtin").equals("0"+barcode)) // nie wiem czemu na stronce dodaja 0
                return null;
        } catch (JSONException e) {
            e.printStackTrace();
        }
       // System.out.println("\n"+json+"\n");
    //    System.out.println(doc);
        return json;

    }

    private static String[] getPicsUrl(Element a, String barcode) {
        String temp [] = new String [2];
        String temps = String.valueOf(a);
        temps = temps.replace("<a href=\"" , "%");
        temps = temps.replace("\" class=\"modal\"> <img src=\"", "%");
        temps = temps.replace("\" alt=\"Zdjęcie produktu\" /> </a>" , "%");
        StringTokenizer stringTokenizer=new StringTokenizer(temps, "$%");
        int iteration=0;
        while(stringTokenizer.hasMoreTokens())
        {
            temp[iteration++]=stringTokenizer.nextToken();
        }
        if(temp[0].contains("0"+barcode))
        {
            temp[0] = "http://www.produktywsieci.pl/brandbank/big/0"+barcode+".jpg";
        }
        if(temp[1].contains("0"+barcode))
        {
            temp[1] = "http://www.produktywsieci.pl/brandbank/small/0"+barcode+".jpg";
        }
        return temp;
    }

    public static String getNameAndGTIN(String temp)
    {

        JSONObject json = new JSONObject();

        temp = temp.replace("Nazwa produktu " , "");
        temp = temp.replace(" Numer GTIN " , "$");
        temp = temp.replace(" Właściciel " , "%");
        StringTokenizer stringTokenizer = new StringTokenizer(temp, "$%");
        String name = "";
        String gtin = "";
        String icon = "";
        String weight = "";
        String weightUnit="";
        while(stringTokenizer.hasMoreTokens())
        {
            name = stringTokenizer.nextToken();
            gtin  = stringTokenizer.nextToken();
            if(!name.equals("") && !gtin.equals("")) {
                break;
            }
        }

        weight = getWeight(name)[0];
        weightUnit= getWeight(name)[1];
        try {
            json.put("name" , name);
            json.put("gtin" , gtin);
            json.put("weight" , weight);
            json.put("weightUnit" , weightUnit);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        //  System.out.println("\nname: " + name + "\nGTIN: " + gtin+"" + "\nICON: " +icon+"\nWEIGHT:" +weight);
        return json.toString();
    }
    public static String [] getWeight(String nazwa)
    {
        String [] weight = new String[2];
        if(nazwa.contains("ml"))
        { weight[1] = "ML";

            weight[0] = weight(nazwa , "ml");
        }
        else if(nazwa.contains("l"))
        {weight[1] = "L";
            weight[0] = weight(nazwa , "l");
        }
        return weight;

    }
    private static String weight(String nazwa ,  String delimiter)
    {
        // nazwa = nazwa.replace(delimiter , "$"+delimiter);
        nazwa = nazwa.replace(" " , "%");
        StringTokenizer stringTokenizer = new StringTokenizer(nazwa, "%");
        ArrayList<String> tempArray = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens())
        {
            tempArray.add(stringTokenizer.nextToken());
        }
        return tempArray.get(tempArray.size()-2);
    }


}
