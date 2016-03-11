package com.soen6461.scrapping.scrapper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 * Created by suryaveer on 2016-02-09.
 */
public class XMLCreator {

    private static DocumentBuilderFactory docFactory;
    private static DocumentBuilder documentBuilder;
    private static Document doc;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(XMLCreator.class);

    XMLCreator() {
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = docFactory.newDocumentBuilder();

            doc = documentBuilder.newDocument();
            //           Element rootElement = doc.createElement("Applications");
//            doc.appendChild(rootElement);
        } catch (Exception e) {
            logger.error("Error while creating XML document.", e);
        }
    }

    Element createRoot(String xmlRoot) {
        Element rootElement = doc.createElement(xmlRoot);
        doc.appendChild(rootElement);
        return rootElement;
    }


    Element createChild(Map<String, String> childRecord, String name) {

        Element childRoot = doc.createElement(name);
        Element childLeaf;
        for (Map.Entry<String, String> entry : childRecord.entrySet()) {
            
            logger.debug("Key: {} " , entry.getKey().replace(" ", "_"));
            logger.debug("Value: {} " , entry.getValue());
            childLeaf = doc.createElement(entry.getKey().replace(" ", "_"));

            
            childLeaf.appendChild(doc.createTextNode(entry.getValue()));
            childRoot.appendChild(childLeaf);
        }

        return childRoot;
    }
    Element addChildFromMap(Map<String, String> childRecord, Element child) {

        
        Element childLeaf;
        for (Map.Entry<String, String> entry : childRecord.entrySet()) {
            childLeaf = doc.createElement(entry.getKey());

            logger.debug("Key: {} " , entry.getKey());
            logger.debug("Value: {} " , entry.getValue());
            childLeaf.appendChild(doc.createTextNode(entry.getValue()));
            child.appendChild(childLeaf);
        }

        return child;
    }
    Document getDocument()
    {
        return doc;
    }

}

