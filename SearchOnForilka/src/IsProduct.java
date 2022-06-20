import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;

public class IsProduct {



     public static void isProduct(Map.Entry<String, String> shop , String prod) throws IOException {
         Connection.Response res = Jsoup.connect(prod).userAgent("Chrome/4.0.249.0").referrer("http://www.google.com")
                 .method(Connection.Method.POST).cookie("my_shop", shop.getValue())
                 .execute();
         Document doc = res.parse();
         Elements nameProduct = doc.select("h1");
         Elements price = doc.getElementsByClass("productData_table_row_mainPrice");
         Elements count = doc.getElementsByClass("productData_table_img");
         if(!count.attr("data-bottles-count").equals("0") && !count.attr("data-bottles-count").equals("")) {
             System.out.println(shop.getKey() + nameProduct.text() + " наличе в магазине " + count.attr("data-bottles-count") + " штук/и/а" + " Цена " + price.text());
         }

    }

}
