import core.Line;
import java.util.*;

public class StationIndex {

    private static final List <Line> lines = new ArrayList<>();

    public void addLine (Line line) {
        lines.add(line);
    }

    public void getStationsQuantity() {
        lines.forEach(line -> {
            System.out.println("Колтчество станций на линии \"" + line.getName() + "\" " + line.getStationsQuantity());
        });

    }
}
