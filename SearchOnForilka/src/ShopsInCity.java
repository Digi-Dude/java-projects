import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;


public class ShopsInCity {
    public static HashMap<String, String> shops(String id) throws IOException {
        HashMap<String, String> shops = new HashMap<>();

        Document doc = Jsoup.connect("https://www.gorilka63.ru/shops/").userAgent("Chrome/4.0.249.0").referrer("http://www.google.com").get();
        Elements cityId = doc.getElementsByAttributeValue("data-city-id",id);
        for (Element element : cityId.select("div.shopList-name")) {
            String shop = element.text().replaceAll("ИНН.*$", "");
            String idShops = element.attr("data-shop-id");
            shops.put(shop, idShops);
        }
        return shops;

    }
}
