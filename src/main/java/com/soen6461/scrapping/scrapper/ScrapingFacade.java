package com.soen6461.scrapping.scrapper;


import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.w3c.dom.Element;
import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 * Created by suryaveer on 2016-02-09.
 */
public class ScrapingFacade {

    //private static final String inputFileName = "D:\\Dropbox\\SOEN6461\\Project\\scraping.csv";
    //private static final String outputFileName = "D:\\Dropbox\\SOEN6461\\Project\\scraped.xml";
    private String inputFileName;
    private String outputFileName;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ScrapingFacade.class);
    private static Map<String, String> scrappedMap;
    private XMLCreator xmlCreator;
    private static final ScrapingFacade INSTANCE = new ScrapingFacade();
    static
    {
        ScrapingFacade instance = new ScrapingFacade();
    }
//    private ScrapingFacade(String inputFileName)
//    {
//        this.inputFileName = inputFileName;
//        this.outputFileName = inputFileName.substring(0, inputFileName.indexOf("."))+".xml";
//    }
    public String scrape(String fileLocation) {
        inputFileName = fileLocation;
        File fileName = new File(inputFileName);
        
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scrapedXML));
        logger.debug("Reading {} file.", inputFileName);

        xmlCreator = new XMLCreator();
        Scrapper scrapper = new Scrapper();
        ParseCSV parseCSV = new ParseCSV();


        Element docRoot = xmlCreator.createRoot("Applications");
        
        CSVParser parser = parseCSV.createParser(fileName);
        //Map<String, Integer> header = parser.getHeaderMap();

        for (CSVRecord csvRecord : parser) {
            System.out.println("Scraping: " + csvRecord.get("Url"));
            scrappedMap = scrapper.scrape(csvRecord.get("Url"));
            //from the csv
            //child = xmlCreator.createChild(csvRecord.toMap(), scrappedMap.get("Title"));
            Element child = xmlCreator.createChild(csvRecord.toMap(), "App");
            //child.setTextContent(scrappedMap.get("Title"));
            System.out.println(child.toString());
            //child.setNodeValue(scrappedMap.get("Title"));
            // from the scrapped Map
            //child.appendChild(xmlCreator.createChild(scrappedMap, "MetaData")); //this creates nested structure
            child=xmlCreator.addChildFromMap(scrappedMap, child); //this creates flat structure
            docRoot.appendChild(child);
            
        }
        System.out.println(docRoot.toString());
        System.out.println("Complete. Writing XML");
        return "Complete";
    }
    
    public static ScrapingFacade getInstance()
    {
            return INSTANCE;
    }
    public void saveFile(String fileLocation)
    {
        if(fileLocation!=null)
            outputFileName=fileLocation;
        else
            outputFileName=inputFileName.substring(0, inputFileName.indexOf("."))+".xml";
        File scrapedXML = new File(outputFileName);
        XMLWriter.writeDocumentToFile(xmlCreator.getDocument(), scrapedXML);
    }
    
}
