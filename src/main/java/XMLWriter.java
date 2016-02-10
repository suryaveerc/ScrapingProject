/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author suryaveer
 */
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMSource; 
import javax.xml.transform.stream.StreamResult; 
import org.slf4j.LoggerFactory;

public class XMLWriter {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(XMLWriter.class);
    public static void writeDocumentToFile(Document document, File file) {

        try {
            // Make a transformer factory to create the Transformer
            TransformerFactory tFactory = TransformerFactory.newInstance();
            
            // Make the Transformer
            Transformer transformer = tFactory.newTransformer();
            
            // Mark the document as a DOM (XML) source
            DOMSource source = new DOMSource(document);
            
            // Say where we want the XML to go
            StreamResult result = new StreamResult(file);
            
            // Write the XML to file
            transformer.transform(source, result);
        } catch (TransformerConfigurationException ex) {
            logger.error("TransformerConfigurationException",ex);
        } catch (TransformerException ex) {
            logger.error("TransformerException",ex);
        }
    }
}
