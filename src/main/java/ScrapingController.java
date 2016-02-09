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

/**
 * Created by suryaveer on 2016-02-09.
 */
public class ScrapingController {

    public static void main(String[] args) {

        File fileName = new File("D:\\Dropbox\\SOEN6461\\Project\\scraping.csv");
        File scrapedXML  = new File("D:\\Dropbox\\SOEN6461\\Project\\scraped.xml");
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(scrapedXML));
        System.out.println(fileName);
        CSVFormat format = CSVFormat.RFC4180.withHeader();
        XMLCreator xmlCreator = new XMLCreator();
        Scrapper scrapper = new Scrapper();
        Map<String, String> scrappedMap = new HashMap<String, String>();
        Element child;
        try {
            Element docRoot = xmlCreator.createRoot("Applications");
            CSVParser parser = CSVParser.parse(fileName, Charset.forName("UTF-8"), format);
            Map<String, Integer> header = parser.getHeaderMap();

            for(CSVRecord csvRecord : parser)
            {
                System.out.println("Scraping: "  + csvRecord.get("Url"));
                scrappedMap = scrapper.scrape(csvRecord.get("Url"));
                //from the csv
                child = xmlCreator.createChild(csvRecord.toMap(),scrappedMap.get("Title"));
                // from the scrapped Map
                child.appendChild(xmlCreator.createChild(scrappedMap,"MetaData"));
                docRoot.appendChild(child);
            }
            System.out.println("Complete. Writing XML");
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(xmlCreator.getDocument());
            StreamResult result = new StreamResult(scrapedXML);
            //StreamResult result = new StreamResult(System.out);
            transformer.transform(source, result);

        }catch(TransformerConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }



}
