import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        List<Flight> nextTwoHour = findPlanesLeavingInTheNextTwoHours(airport);
        for (Flight flight : nextTwoHour) {
            System.out.println(flight);
        }
    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        LocalDateTime now = LocalDateTime.now();
        return airport.getTerminals().stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(flight -> flight.getType().equals(Flight.Type.DEPARTURE))
                .filter(flight -> dateToLocalDate(flight.getDate())
                        .isAfter(now) && dateToLocalDate(flight.getDate())
                        .isBefore(now.plusHours(2)))
                .collect(Collectors.toList());

    }
    private static LocalDateTime dateToLocalDate(Date date) {
        return LocalDateTime
                .ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

}