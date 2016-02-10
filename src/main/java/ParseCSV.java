
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.slf4j.LoggerFactory;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author suryaveer
 */
public class ParseCSV {

    private static CSVFormat format;
    private static CSVParser parser;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ParseCSV.class);

    ParseCSV() {

        format = CSVFormat.RFC4180.withHeader();

    }

    CSVParser createParser(File fileName) {
        try {
            parser = CSVParser.parse(fileName, Charset.forName("UTF-8"), format);
        } catch (IOException ex) {
            logger.error("Error while creating parser",ex);
        }
        return parser;
    }

}
