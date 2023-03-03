package implemica.FindShortestPath.storage;

import java.util.HashMap;
import java.util.Map;
import implemica.FindShortestPath.model.City;

public class RoutesStorage {
    private static final Map<City, City> routes = new HashMap<>();

    public static Map<City, City> getRoutes() {
        return routes;
    }
}
