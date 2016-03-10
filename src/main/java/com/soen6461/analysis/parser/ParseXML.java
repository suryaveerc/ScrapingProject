/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soen6461.analysis.parser;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 * @author suryaveer
 */
public class ParseXML {

    static int level = 1;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ParseXML.class);

    public static Map<String, Object> parseXMLToMap(File file) {
        Map<String, Object> scrappedMap = null;
        // String xmlString = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Applications><Instagram><SEMrush_links>5520</SEMrush_links><MetaData><Rating-Two>584,332</Rating-Two></MetaData></Instagram></Applications>";
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory
                .newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docBuilderFactory.newDocumentBuilder();
            Document document = docBuilder.parse(file);
            Map<String, Object> applicationKey = new HashMap<>();
            scrappedMap = parseXMLToMap(clearEmptyNodes(document).getDocumentElement(), applicationKey, true);
        } catch (ParserConfigurationException e) {
        } catch (SAXException | IOException | XPathExpressionException ex) {
            logger.error("Exception parsing file", ex);
        }
        //Document document = docBuilder.parse(new InputSource(new StringReader(xmlString)));

        return scrappedMap;
    }

    public static Map<String, Object> parseXMLToMap(Node node, Map<String, Object> applicationKey, Boolean addToMap) {
        NodeList rootNodeList = node.getChildNodes();
        int len = rootNodeList.getLength();
        logger.debug("Parent Node: {}, Children: {}", node.getNodeName(), len);
        Map<String, Object> applicationValuesMap = new HashMap<>();

        //Added check if this is called recursively do not add to map as the returned map will be added.
        if (addToMap) {
            applicationKey.put(node.getNodeName(), applicationValuesMap);
        } else {
            applicationValuesMap = applicationKey;
        }
        for (int i = 0; i < len; i++) {
            Node currentNode = rootNodeList.item(i);
            int currentNoteChildCount = currentNode.getChildNodes().getLength();
            logger.debug("Child Node: {}, Children: {}", ((Element) currentNode).getTagName(), currentNoteChildCount);
            if (currentNoteChildCount == 1 && currentNode.getFirstChild().getNodeType() == 3)//checking for text node
            {
                applicationValuesMap.put(((Element) currentNode).getTagName(), ((Element) currentNode).getTextContent());
                logger.debug("Node: {}", ((Element) currentNode).getTagName());
                logger.debug("Value: {}", ((Element) currentNode).getTextContent());
            } else if (currentNode.getNodeType() == Node.ELEMENT_NODE && currentNoteChildCount > 0) {
                logger.debug("Creating map for: {}", ((Element) currentNode).getTagName());
                Map<String, Object> subValues = new HashMap<>();

                applicationValuesMap.put(((Element) currentNode).getTagName(), parseXMLToMap(currentNode, subValues, false));
            }
        }
        return applicationKey;
    }

    //Source http://j2stuff.blogspot.ca/2012/06/method-to-clear-empty-xml-nodes.html
    //Utility method to remove useless blank text nodes.
    public static Document clearEmptyNodes(Document doc) throws XPathExpressionException {
        XPathFactory xpathFactory = XPathFactory.newInstance();
        // XPath to find empty text nodes.
        XPathExpression xpathExp = xpathFactory.newXPath().compile(
                "//text()[normalize-space(.) = '']");
        NodeList emptyTextNodes = (NodeList) xpathExp.evaluate(doc, XPathConstants.NODESET);

        // Remove each empty text node from document.
        for (int i = 0; i < emptyTextNodes.getLength(); i++) {
            Node emptyTextNode = emptyTextNodes.item(i);
            emptyTextNode.getParentNode().removeChild(emptyTextNode);
        }
        return doc;
    }

    //Test function to print generated map.
    
}
