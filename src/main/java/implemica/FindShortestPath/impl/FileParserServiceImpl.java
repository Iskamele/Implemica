package implemica.FindShortestPath.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import implemica.FindShortestPath.model.City;
import implemica.FindShortestPath.service.FileParserService;
import implemica.FindShortestPath.storage.CitiesStorage;
import implemica.FindShortestPath.storage.RoutesStorage;

public class FileParserServiceImpl implements FileParserService {
    private static final int INDEX_TESTS_COUNT = 0;
    private static final int INDEX_CITIES_COUNT = 1;
    private static final int INDEX_FIRST_CITY = 2;

    @Override
    public void parseInput(List<String> input) {
        Map<Integer, List<String>> neighborsMap = new HashMap<>();
        int processedLines = addCities(input, neighborsMap);
        addNeighbors(neighborsMap);
        addRoutes(input, processedLines);
    }

    private void addRoutes(List<String> input, int processedLines) {
        int routesCountLine = processedLines + 1;
        for (int i = routesCountLine; i < input.size(); i++) {
            String[] cities = input.get(i).split(" ");
            City cityFrom = CitiesStorage.getCityByName(cities[0]);
            City cityTo = CitiesStorage.getCityByName(cities[1]);
            RoutesStorage.getRoutes().put(cityFrom, cityTo);
        }
    }

    private int addCities(List<String> input, Map<Integer, List<String>> neighborsMap) {
        int countCity = Integer.parseInt(input.get(INDEX_CITIES_COUNT));
        int cityId = 1;
        int i = INDEX_FIRST_CITY;
        while (countCity > 0 && i < input.size()) {
            String cityName = input.get(i);
            int currentCityNeighbors = Integer.parseInt(input.get(i + 1));
            List<String> currentCityRoad = input.subList(i + 2, i + currentCityNeighbors + 2);
            neighborsMap.put(cityId, currentCityRoad);
            CitiesStorage.addCity(new City(cityId++, cityName));
            countCity--;
            i += currentCityNeighbors + 2;
        }
        return i;
    }

    private void addNeighbors(Map<Integer, List<String>> neighborsMap) {
        for (Map.Entry<Integer, List<String>> entry : neighborsMap.entrySet()) {
            for (String value : entry.getValue()) {
                String[] cityIdAndCost = value.split(" ");
                int neighborId = Integer.parseInt(cityIdAndCost[0]);
                int neighborCost = Integer.parseInt(cityIdAndCost[1]);
                City neighbor = CitiesStorage.getCityById(neighborId);
                CitiesStorage.getCities().get(entry.getKey() - 1).addNeighbor(neighbor, neighborCost);
            }
        }
    }
}