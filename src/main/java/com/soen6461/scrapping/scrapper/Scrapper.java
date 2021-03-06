package com.soen6461.scrapping.scrapper;


import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;

/**
 * Created by suryaveer on 2016-02-09.
 */
public class Scrapper {

    private Document doc;
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ParseCSV.class);
    private Map<String, String> appMetaData;
    private final String itempropArray[] = {"ratingValue", "ratingCount", "numDownloads", "datePublished", "operatingSystems", "contentRating"};
    private String value;

    public Map<String, String> scrape(String url) {
        try {
            doc = Jsoup.connect(url).get();
            appMetaData = new HashMap<String, String>();
            //metadata = doc.select(key);

            value = doc.select("h1.document-title").text().replaceAll(":", "").replaceAll(" ", "_").replaceAll("&", "and").replaceAll("[^\\x00-\\x7F]", "");
            logger.debug("Title: {} ", value);
            appMetaData.put("Title", value);

            value = doc.select("div.score").text();
            logger.debug("score: {} ", value);
            appMetaData.put("Average-Rating", value);

            value = doc.select("div.rating-bar-container.five > span.bar-number").text();
            logger.debug("Rating-Five: {} ", value);
            appMetaData.put("Rating-Five", value);

            value = doc.select("div.rating-bar-container.four > span.bar-number").text();
            logger.debug("Rating-Four: {} ", value);
            appMetaData.put("Rating-Four", value);

            value = doc.select("div.rating-bar-container.three > span.bar-number").text();
            logger.debug("Rating-Three: {} ", value);
            appMetaData.put("Rating-Three", value);

            value = doc.select("div.rating-bar-container.two > span.bar-number").text();
            logger.debug("Rating-Two: {} ", value);
            appMetaData.put("Rating-Two", value);

            value = doc.select("div.rating-bar-container.one > span.bar-number").text();
            logger.debug("Rating-One: {} ", value);
            appMetaData.put("Rating-One", value);

            value = doc.select("div.details-section-contents.show-more-container").select("div.recent-change").text().replaceAll("[^\\x00-\\x7F]", "");
            logger.debug("Whats_New: {} ", value);
            appMetaData.put("Whats_New", value);
//            TODO: Need to format ratings tag.
            String itemPropString;
            for (String itemProp : itempropArray) {
                itemPropString = String.format("div[itemprop=%s", itemProp, "]");
                value = doc.select(itemPropString).text();
                logger.debug("itemProp: {} ", value);
                appMetaData.put("itemProp", value);
            }
        } catch (IOException ex) {
            logger.error("Error while fetching the URL- {}.",url, ex);
        }
        return appMetaData;
    }
}
