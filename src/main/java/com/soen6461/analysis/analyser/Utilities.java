/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen6461.analysis.analyser;


import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.LoggerFactory;

/**
 *
 * @author chauh
 */
public class Utilities {
        private static final org.slf4j.Logger logger = LoggerFactory.getLogger(Utilities.class);

    private static void printHashMap(HashMap<String, Object> map) {
        for (String key : map.keySet()) {
            logger.debug("{} = {}", key, map.get(key));
            if (map.get(key) instanceof HashMap) {
                printHashMap((HashMap) map.get(key));
            }
        }
    }
     private static ArrayList<String> getAllKeysFromMap(HashMap<String, Object> map) {
         ArrayList<String> keysList = new ArrayList<>();
        for (String key : map.keySet()) {
            logger.debug("{} = {}", key, map.get(key));
            keysList.add(key);
            if (map.get(key) instanceof HashMap) {
                printHashMap((HashMap) map.get(key));
            }
        }
        return keysList;
    }
}
