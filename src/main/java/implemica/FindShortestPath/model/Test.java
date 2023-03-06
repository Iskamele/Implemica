package implemica.FindShortestPath.model;

import java.util.ArrayList;
import java.util.List;

public class Test {
    private int number;
    private final List<City> cities;
    private final List<Route> routes;

    public Test() {
        cities = new ArrayList<>();
        routes = new ArrayList<>();
    }

    public void setNumber(int number) {
        this.number = number;
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
        throw new RuntimeException("City by NAME not found.");
    }

    public City getCityById(int cityId) {
        for (City city : cities) {
            if (city.getId() == cityId) {
                return city;
            }
        }
        throw new RuntimeException("City by ID not found.");
    }

    public void addRoute(City from, City to) {
        Route route = new Route(from, to);
        routes.add(route);
    }

    public List<Route> getRoutes() {
        return routes;
    }
}
