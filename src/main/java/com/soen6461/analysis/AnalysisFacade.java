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

/**
 *
 * @author chauh
 */
public class AnalysisFacade {

    private String inputFileName;
    private String outputFileName;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AnalysisFacade.class);
    private static Map<String, String> scrappedMap;

    public AnalysisFacade(String inputFileName) {
        this.inputFileName = inputFileName;
        this.outputFileName = inputFileName.substring(0, inputFileName.indexOf(".")) + ".xml";
    }

    public String analyseData() {
        ParseXML.parseXMLToMap(new File(inputFileName));
        return "Done";
    }
}
