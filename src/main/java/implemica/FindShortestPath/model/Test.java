package implemica.FindShortestPath.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    private static int number;
    private final List<City> cities;
    private final Map<City, City> routes;

    public Test() {
        cities = new ArrayList<>();
        routes = new HashMap<>();
    }

    public void setNumber(int number) {
        Test.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void addCity(City city) {
        cities.add(city);
    }

    public List<City> getCities() {
        return cities;
    }

    public City getCityByName(String cityName) {
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return city;
            }
        }
        return null; // TODO throw an exception if city not found
    }

    public City getCityById(int cityId) {
        for (City city : cities) {
            if (city.getId() == cityId) {
                return city;
            }
        }
        return null; // TODO throw an exception if city not found
    }

    public void addRoute(City from, City to) {
        routes.put(from, to);
    }

    public Map<City, City> getRoutes() {
        return routes;
    }
}
