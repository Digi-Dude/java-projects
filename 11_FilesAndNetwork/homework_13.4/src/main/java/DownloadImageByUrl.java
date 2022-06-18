import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DownloadImageByUrl {
    private final ArrayList<String> imgUrls = new ArrayList<>();
    private final String directoryPath = "src/images/";
    private final String url;

    public DownloadImageByUrl(String url) {
        this.url = url;
    }

    public void getUrlImages() throws IOException {
        Connection connect = Jsoup.connect(this.url);
        Document doc = connect.get();
        Elements elements = doc.getElementsByTag("img");
        elements.forEach(element -> imgUrls.add(element.attr("abs:src")));
    }

    public void downloadImages() throws IOException {
        for (String url: imgUrls) {
            if (url.endsWith(".jpg") || url.endsWith(".png") || url.endsWith(".gif")) {
                String[] namesFiles = url.split("/");
                String name = namesFiles[namesFiles.length-1];
                System.out.println(name);
                if(!new File(directoryPath).exists()) {
                    Files.createDirectory(Paths.get(directoryPath));
                }
                String targetFile = directoryPath + name;
                FileUtils.copyURLToFile(new URL(url), new File(targetFile));
            }
        }
    }
}
