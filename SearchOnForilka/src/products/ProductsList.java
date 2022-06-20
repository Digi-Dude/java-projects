package products;

import comparator.LowComparator;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;



public class ProductsList {

    public static ArrayList<Product> getProdList (ArrayList<Shop> shops, String prod) throws IOException {
        ArrayList<Product> products = new ArrayList<>();
        float loadCount = 1;
        float fullLoad = shops.size();
        for (Shop shop: shops) {
            if ((loadCount / fullLoad * 100) % 10 == 0) {
                System.out.println("load " + (int)(loadCount / fullLoad * 100.0) + "%");
            }
            Connection.Response res = Jsoup.connect(prod).userAgent("Chrome/4.0.249.0").referrer("http://www.google.com")
                    .method(Connection.Method.POST).cookie("my_shop", shop.getId())
                    .execute();
            Document doc = res.parse();
            Elements nameProduct = doc.select("h1");
            Elements price = doc.getElementsByClass("productData_table_row_mainPrice");
            Elements count = doc.getElementsByClass("productData_table_img");
            if(!count.attr("data-bottles-count").equals("0") && !count.attr("data-bottles-count").equals("")) {
                products.add(new Product(nameProduct.text(),
                        Integer.parseInt(count.attr("data-bottles-count")),
                        Double.parseDouble(price.text().replaceAll("\\D", "")),
                        shop.getAddress()));
            }
            loadCount += 1;

        }
        products.sort(new LowComparator());
        return products;
    }
}
