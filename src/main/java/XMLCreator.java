import org.w3c.dom.Document;
import org.w3c.dom.Element;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by suryaveer on 2016-02-09.
 */
public class XMLCreator {

    private static DocumentBuilderFactory docFactory;
    private static DocumentBuilder documentBuilder;
    private static Document doc;

    XMLCreator() {
        try {
            docFactory = DocumentBuilderFactory.newInstance();
            documentBuilder = docFactory.newDocumentBuilder();

            doc = documentBuilder.newDocument();
            //           Element rootElement = doc.createElement("Applications");
//            doc.appendChild(rootElement);
        } catch (Exception e) {
            e.printStackTrace();
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
            System.out.println("Name: "+ entry.getKey());
            childLeaf = doc.createElement(entry.getKey());

            System.out.println("Key : " + entry.getKey() + " Value :" + entry.getValue());
            childLeaf.appendChild(doc.createTextNode(entry.getValue()));
            childRoot.appendChild(childLeaf);
        }

        return childRoot;
    }
    Document getDocument()
    {
        return doc;
    }

}

