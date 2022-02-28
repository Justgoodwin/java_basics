import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRouteCalculator extends TestCase {

    StationIndex stationIndex;
    List<Station> actualRoute = new ArrayList<>();
    RouteCalculator routeCalculator;

    @Override
    protected void setUp(){
        stationIndex = new StationIndex();

        Line line1 = new Line(1,"Red");
        Line line2 = new Line(2,"Yellow");
        Line line3 = new Line(3,"Green");

        String[] line_1_Names = {"Tomato","Beet","Pepper","Cranberry"};
        String[] line_2_Names = {"Lemon","Banana","Pineapples","Mango"};
        String[] line_3_Names = {"Cabbage","Celery","Asparagus","Spinach"};

        for (String line_1_name : line_1_Names) {
            line1.addStation(new Station(line_1_name, line1));
            stationIndex.addStation(new Station(line_1_name, line1));
        }
        for (String line_2_name : line_2_Names) {
            line2.addStation(new Station(line_2_name, line2));
            stationIndex.addStation(new Station(line_2_name, line2));
        }
        for (String line_3_name : line_3_Names) {
            line3.addStation(new Station(line_3_name, line3));
            stationIndex.addStation(new Station(line_3_name, line3));
        }
        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        List<Station> line_1_and_2_connection = new ArrayList<>();
        List<Station> line_2_and_3_connection = new ArrayList<>();
        line_1_and_2_connection.add(stationIndex.getStation("Pepper"));
        line_1_and_2_connection.add(stationIndex.getStation("Lemon"));
        line_2_and_3_connection.add(stationIndex.getStation("Pineapples"));
        line_2_and_3_connection.add(stationIndex.getStation("Celery"));

        stationIndex.addConnection(line_1_and_2_connection);
        stationIndex.addConnection(line_2_and_3_connection);

        actualRoute.add(stationIndex.getStation("Tomato"));
        actualRoute.add(stationIndex.getStation("Beet"));
        actualRoute.add(stationIndex.getStation("Pepper"));
        actualRoute.add(stationIndex.getStation("Lemon"));
        actualRoute.add(stationIndex.getStation("Banana"));
        actualRoute.add(stationIndex.getStation("Pineapples"));
        actualRoute.add(stationIndex.getStation("Celery"));
        actualRoute.add(stationIndex.getStation("Asparagus"));
        actualRoute.add(stationIndex.getStation("Spinach"));

        routeCalculator = new RouteCalculator(stationIndex);
    }

    public void  testGetShortestRoute_GetRouteOnTheLine(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Tomato",1),
                stationIndex.getStation("Cranberry",1));
        List<Station> expected = Stream.of(stationIndex.getStation("Tomato"),
                stationIndex.getStation("Beet"),
                stationIndex.getStation("Pepper"),
                stationIndex.getStation("Cranberry")).collect(Collectors.toList());
        assertEquals(expected,actual);
    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(actualRoute);
        double expected = 22.0;
        assertEquals(expected,actual);
    }

    public void testGetShortestRoute_GetRouteWithOneConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Tomato",1),
                stationIndex.getStation("Mango",2));
        List<Station> expected = Stream.of(stationIndex.getStation("Tomato"),
                stationIndex.getStation("Beet"),
                stationIndex.getStation("Pepper"),
                stationIndex.getStation("Lemon"),
                stationIndex.getStation("Banana"),
                stationIndex.getStation("Pineapples"),
                stationIndex.getStation("Mango")).collect(Collectors.toList());
        assertEquals(expected,actual);
    }

    public void testGetShortestRoute_GetRouteWithTwoConnection(){
        List<Station> actual = routeCalculator.getShortestRoute(stationIndex.getStation("Tomato",1),
                stationIndex.getStation("Cabbage",3));
        List<Station> expected = Stream.of(stationIndex.getStation("Tomato"),
                stationIndex.getStation("Beet"),
                stationIndex.getStation("Pepper"),
                stationIndex.getStation("Lemon"),
                stationIndex.getStation("Banana"),
                stationIndex.getStation("Pineapples"),
                stationIndex.getStation("Celery"),
                stationIndex.getStation("Cabbage")).collect(Collectors.toList());
        assertEquals(expected,actual);
    }
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
