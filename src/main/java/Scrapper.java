
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import java.util.HashMap;

import java.util.Map;

/**
 * Created by suryaveer on 2016-02-09.
 */
public class Scrapper {

    Document doc;
    Map<String, String> appMetaData;
    Element element;
    Elements elements;
    String itempropArray[] = {"ratingValue", "ratingCount", "numDownloads", "datePublished", "operatingSystems", "contentRating"};
    String value;

    public Map<String, String> scrape(String url) {
        try {
            doc = Jsoup.connect(url).get();
            appMetaData = new HashMap<String, String>();
            //metadata = doc.select(key);

            value = doc.select("h1.document-title").text().replaceAll(":", "").replaceAll(" ", "_").replaceAll("&", "and").replaceAll("[^\\x00-\\x7F]", "");
            System.out.println("Title: " + value);
            appMetaData.put("Title", value);

            value = doc.select("div.score").text();
            System.out.println("score: " + value);
            appMetaData.put("Rating", value);

            value = doc.select("div.rating-bar-container.five > span.bar-number").text();
            System.out.println("five: " + value);
            appMetaData.put("five", value);

            value = doc.select("div.rating-bar-container.four > span.bar-number").text();
            System.out.println("Four: " + value);
            appMetaData.put("Four", value);

            value = doc.select("div.rating-bar-container.three > span.bar-number").text();
            System.out.println("Three: " + value);
            appMetaData.put("Three", value);

            value = doc.select("div.rating-bar-container.two > span.bar-number").text();
            System.out.println("Two: " + value);
            appMetaData.put("Two", value);

            value = doc.select("div.rating-bar-container.one > span.bar-number").text();
            System.out.println("One: " + value);
            appMetaData.put("One", value);

            value = doc.select("div.details-section-contents.show-more-container").select("div.recent-change").text().replaceAll("[^\\x00-\\x7F]", "");
            System.out.println("Whats_New: " + value);
            appMetaData.put("Whats_New", value);

            String itemPropString;
            for (String itemProp : itempropArray) {
                itemPropString = String.format("div[itemprop=%s", itemProp, "]");
                value = doc.select(itemPropString).text();
                System.out.println("--: " + value);
                appMetaData.put("itemProp", value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return appMetaData;
    }
}
