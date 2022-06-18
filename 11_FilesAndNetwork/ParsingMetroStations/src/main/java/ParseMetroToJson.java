import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ParseMetroToJson {
    private static final String DESTINATION_PATH = "src/main/resources/map.json";
    private static final String CSS_FOR_LINES_LIST = "span[data-line]";
    private static final String CSS_FOR_STATIONS_LIST = "div[data-line]";
    private static final String ATTRIBUTE_KEY_FOR_LINE = "data-line";
    private static final String PATH_FOR_EACH_STATION = " >p > a[data-metrost] > .name";
    private static int count;
    private static String json;

    public static void ParseToJson(String sourceUrl) {
        try {
            Path jsonFile = Paths.get(DESTINATION_PATH);
            Document doc = Jsoup.connect(sourceUrl).maxBodySize(0).get();
            Elements linesElements = doc.select(CSS_FOR_LINES_LIST);
            Elements stationsElements = doc.select(CSS_FOR_STATIONS_LIST);
            List lines = new JSONArray();
            JSONObject mskMetro = new JSONObject();
            linesElements.forEach(element ->
                    {
                        JSONObject data = new JSONObject();
                        data.put("number", (element.attr(ATTRIBUTE_KEY_FOR_LINE)));
                        data.put("name", element.text());
                        lines.add(data);
                    }
            );
            JSONObject station = new JSONObject();
            count = 0;
            stationsElements.forEach(element -> {
                JSONArray stations1 = new JSONArray();
                element.select(PATH_FOR_EACH_STATION).forEach(element1 -> {
                    stations1.add(element1.text());
                });
                station.put(linesElements.get(count).attr(ATTRIBUTE_KEY_FOR_LINE), stations1);
                count++;});
            mskMetro.put("stations", station);
            mskMetro.put("lines", lines);
            json = new GsonBuilder().setPrettyPrinting().create().toJson(mskMetro);
            Files.write(jsonFile, json.getBytes(StandardCharsets.UTF_8));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


}
