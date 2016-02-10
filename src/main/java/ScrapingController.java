
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.w3c.dom.Element;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 * Created by suryaveer on 2016-02-09.
 */
public class ScrapingController {

    private static final String inputFileName = "D:\\Dropbox\\SOEN6461\\Project\\scraping.csv";
    private static final String outputFileName = "D:\\Dropbox\\SOEN6461\\Project\\scraped.xml";
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ScrapingController.class);
    private static Map<String, String> scrappedMap;

    public static void main(String[] args) {

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

    }

}
