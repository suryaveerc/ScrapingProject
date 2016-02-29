package scrapping.scrapper;


import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.w3c.dom.Element;
import java.io.*;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 * Created by suryaveer on 2016-02-09.
 */
public class ScrapingController {

    //private static final String inputFileName = "D:\\Dropbox\\SOEN6461\\Project\\scraping.csv";
    //private static final String outputFileName = "D:\\Dropbox\\SOEN6461\\Project\\scraped.xml";
    private String inputFileName;
    private String outputFileName;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ScrapingController.class);
    private static Map<String, String> scrappedMap;

    public ScrapingController(String inputFileName)
    {
        this.inputFileName = inputFileName;
        this.outputFileName = inputFileName.substring(0, inputFileName.indexOf("."))+".xml";
    }
    public String scrape() {

        File fileName = new File(inputFileName);
        File scrapedXML = new File(outputFileName);
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scrapedXML));
        logger.debug("Reading {} file.", inputFileName);

        XMLCreator xmlCreator = new XMLCreator();
        Scrapper scrapper = new Scrapper();
        ParseCSV parseCSV = new ParseCSV();
        Element child;

        Element docRoot = xmlCreator.createRoot("Applications");
        CSVParser parser = parseCSV.createParser(fileName);
        //Map<String, Integer> header = parser.getHeaderMap();

        for (CSVRecord csvRecord : parser) {
            System.out.println("Scraping: " + csvRecord.get("Url"));
            scrappedMap = scrapper.scrape(csvRecord.get("Url"));
            //from the csv
            child = xmlCreator.createChild(csvRecord.toMap(), scrappedMap.get("Title"));
            // from the scrapped Map
            child.appendChild(xmlCreator.createChild(scrappedMap, "MetaData"));
            docRoot.appendChild(child);
        }
        System.out.println("Complete. Writing XML");
        XMLWriter.writeDocumentToFile(xmlCreator.getDocument(), scrapedXML);
        return "Complete";
    }

}
