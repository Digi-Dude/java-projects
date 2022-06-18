import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Site {

    private String url;
    private boolean linkChild;
    private TreeSet<Site> Sites = new TreeSet<>(Comparator.comparing(o -> o.url));

    public Site(String url) {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
    public void setUrl(String url)
    {
        this.url = url;
    }
    public boolean isLinkChild()
    {
        return linkChild;
    }
    public void setLinkChild(boolean linkChild)
    {
        this.linkChild = linkChild;
    }

    public List<String> getUrls()
    {
        List<String> urls = new ArrayList<>();
        try
        {
            Thread.sleep(100);
            Document doc  = Jsoup.connect(url).userAgent("Chrome/4.0.249.0")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .ignoreContentType(true).get();
            Elements link = doc.select("a");
            link.forEach(e -> {
                String href = e.absUrl("href");
                if (href.contains(url)) {
                    urls.add(href);
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return urls;
    }

    public TreeSet<Site> getSites() {
        return Sites;
    }

}
