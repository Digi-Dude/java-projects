import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Flight> nAirport = findPlanesLeavingInTheNextTwoHours(airport);
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        List<Flight> flights = new ArrayList<>();
        List<Terminal> terminals = airport.getTerminals();

        terminals.forEach(terminal -> flights.addAll(terminal.getFlights().stream()
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE)
                .filter(flight -> {
                    Calendar currentDate = Calendar.getInstance();
                    Calendar lastDate = Calendar.getInstance();
                    lastDate.add(Calendar.HOUR, 2);
                    Calendar flightDate = Calendar.getInstance();
                    flightDate.setTime(flight.getDate());
                    return (flightDate.after(currentDate) && flightDate.before(lastDate));})
                .collect(Collectors.toCollection(ArrayList::new))));
            return flights;
}


    }



