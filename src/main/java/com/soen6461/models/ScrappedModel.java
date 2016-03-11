/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen6461.models;

import java.util.ArrayList;
import java.util.Map;
import com.soen6461.utils.Utilities;
import java.util.HashMap;

/**
 *
 * @author chauh
 */
public class ScrappedModel {
    private HashMap<String, ArrayList<String>> scrappedData;
    private ArrayList<String> keys;

    public ArrayList<String> getKeys() {
        return scrappedData.get("DataPoints");
    }

    public void setKeys(ArrayList<String> keys) {
        this.keys = keys;
    }
    
    public void setScrappedData(HashMap<String, ArrayList<String>> data)
    {
        System.out.println(data);
        this.scrappedData = data;
    }
    
    public HashMap<String, ArrayList<String>> getScrappedData()
    {
        return scrappedData;
    }
     
//    private ArrayList<String> generateKeys()
//    {
//        Map.Entry<String,Object> firstApplication=scrappedData.entrySet().iterator().next();
//        //Map.Entry<String, Object> firstApplicationKeys = firstApplication.getValue();
//        System.out.println("Key: "+firstApplication.getKey());
//        System.out.println("Value: "+firstApplication.getValue());
//        keys = Utilities.getAllKeysFromMap((HashMap<String, Object>) firstApplication.getValue());
//        return keys;
//    }
}
