
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

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

    ParseCSV() {

        format = CSVFormat.RFC4180.withHeader();

    }

    CSVParser createParser(File fileName) {
        try {
            parser = CSVParser.parse(fileName, Charset.forName("UTF-8"), format);
        } catch (IOException ex) {
            Logger.getLogger(ParseCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return parser;
    }

}
