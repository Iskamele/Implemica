package implemica.FindShortestPath.storage;

import java.util.ArrayList;
import java.util.List;
import implemica.FindShortestPath.model.City;

public class CitiesStorage {
    private static final List<City> cities = new ArrayList<>();

    public static List<City> getCities() {
        return cities;
    }

    public static void addCityToStorage(City city) {
        cities.add(city);
    }

    public static City getCityByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null; // TODO throw an exception if city not found
    }
}
