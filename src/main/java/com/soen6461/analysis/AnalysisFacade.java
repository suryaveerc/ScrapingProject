/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen6461.analysis;

import com.soen6461.analysis.parser.ParseXML;
import java.io.File;
import java.util.Map;
import org.slf4j.LoggerFactory;
import com.soen6461.models.ScrappedModel;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author chauh
 */
public class AnalysisFacade {

    private String inputFileName;
    private String outputFileName;
    private static final AnalysisFacade INSTANCE = new AnalysisFacade();
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AnalysisFacade.class);
    private static HashMap<String, ArrayList<String>> scrappedMap;
    private HashMap<String, ArrayList<String>> analysisModel;
    private ScrappedModel scrappedModel;
//    public AnalysisFacade(String inputFileName) {
//        this.inputFileName = inputFileName;
//        this.outputFileName = inputFileName.substring(0, inputFileName.indexOf(".")) + ".xml";
//    }

//    static {
//        System.out.println();
//        AnalysisFacade instance = new AnalysisFacade();
//    }

    public String analyseData(String fileLocation) {
        inputFileName = fileLocation;
        analysisModel = ParseXML.parseXML(new File(inputFileName));
        scrappedModel = new ScrappedModel();
        scrappedModel.setScrappedData(analysisModel);
        scrappedModel.getKeys();
        return "Done";
    }
    private AnalysisFacade(){}
    public static AnalysisFacade getInstance() {
        
        return INSTANCE;
    }
    
    public ArrayList<String> getAvailableKeys()
    {
        return  scrappedModel.getKeys();
    }
    public HashMap<String, ArrayList<String>> getScrappedModel()
    {
        return  scrappedModel.getScrappedData();
    }
    static
    {
        System.out.println("Initiaized****************************");
    }
}
