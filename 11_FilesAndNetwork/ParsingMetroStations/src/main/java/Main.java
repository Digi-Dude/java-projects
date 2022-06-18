import core.Line;
import core.Station;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    private static final String SOURCE_URL = "https://www.moscowmap.ru/metro.html#lines";
    private static final String DESTINATION_PATH = "src/main/resources/map.json";
    private static StationIndex stationIndex;



    public static void main(String[] args) {
        ParseMetroToJson.ParseToJson(SOURCE_URL);
        createStationIndex();
        stationIndex.getStationsQuantity();

    }
    private static void createStationIndex() {
        stationIndex = new StationIndex();
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonData = (JSONObject) parser.parse(getJsonFile());

            JSONArray linesArray = (JSONArray) jsonData.get("lines");
            JSONObject stationsObject = (JSONObject) jsonData.get("stations");
            parsheLine(stationsObject, linesArray);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void parsheLine(JSONObject stationObject, JSONArray linesArray) {
        linesArray.forEach(lineObj -> {
            JSONObject lineJsonObject = (JSONObject) lineObj;
            Line line = new Line(
                    (String) lineJsonObject.get("number"),
                    (String) lineJsonObject.get("name")
            );
            JSONArray stationArray = (JSONArray) stationObject.get(lineJsonObject.get("number"));
            stationArray.forEach(stationObj -> {
                Station station = new Station(stationObj.toString(), line);
                line.addStation(station);
            });
            stationIndex.addLine(line);
        });

    }

    private static String getJsonFile() {
        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines(Paths.get(DESTINATION_PATH));
            lines.forEach(line -> builder.append(line));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();
    }
}
