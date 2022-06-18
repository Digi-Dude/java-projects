import com.skillbox.airport.Airport;


public class App {
    public static void main(String[] args) {
        
        Airport airport = Airport.getInstance();
        // System.out.println(airport.getAllAircrafts());
        int count = airport.getAllAircrafts().size();
        System.out.println(count);

    }
}
