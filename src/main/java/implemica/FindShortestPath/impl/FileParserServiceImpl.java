package implemica.FindShortestPath.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import implemica.FindShortestPath.model.City;
import implemica.FindShortestPath.model.Test;
import implemica.FindShortestPath.service.FileParserService;

public class FileParserServiceImpl implements FileParserService {
    private static final int INDEX_TESTS_COUNT = 0;
    private static final int INDEX_START_LINE = 1;
    private int processedLines = INDEX_START_LINE;

    @Override
    public List<Test> parseInput(List<String> input) {
        List<Test> tests = new ArrayList<>();

        int testsNumber = Integer.parseInt(input.get(INDEX_TESTS_COUNT));
        // int testIndex = 1;
        while (testsNumber > 0) {
            testsNumber--;
            tests.add(newFun(input));
        }
        return tests;
    }

    private Test newFun(List<String> input) {
        Test test = new Test();
        Map<Integer, List<String>> neighborsMap = new HashMap<>();
        processedLines = addCities(input, test, neighborsMap, processedLines);
        addNeighbors(test, neighborsMap);
        processedLines = addRoutes(input, test, processedLines);
        //test.setNumber(testIndex);
        processedLines++;
        return test;
    }

    private int addCities(List<String> input, Test test, Map<Integer, List<String>> neighborsMap, int processedLines) {
        int countCity = Integer.parseInt(input.get(processedLines++));
        int cityId = 1;
        int i = processedLines;
        while (countCity > 0 && i < input.size()) {
            String cityName = input.get(i);
            int currentCityNeighbors = Integer.parseInt(input.get(i + 1));
            List<String> currentCityRoad = input.subList(i + 2, i + currentCityNeighbors + 2);
            neighborsMap.put(cityId, currentCityRoad);
            test.addCity(new City(cityId++, cityName));
            countCity--;
            i += currentCityNeighbors + 2;
        }
        return i;
    }

    private void addNeighbors(Test test, Map<Integer, List<String>> neighborsMap) {
        for (Map.Entry<Integer, List<String>> entry : neighborsMap.entrySet()) {
            for (String value : entry.getValue()) {
                String[] cityIdAndCost = value.split(" ");
                int neighborId = Integer.parseInt(cityIdAndCost[0]);
                int neighborCost = Integer.parseInt(cityIdAndCost[1]);
                City neighbor = test.getCityById(neighborId);

                // TODO заменить на getCity
                test.getCities().get(entry.getKey() - 1).addNeighbor(neighbor, neighborCost);
            }
        }
    }

    private int addRoutes(List<String> input, Test test, int processedLines) {
        int routesStartLine = processedLines + 1;
        int routesCount = Integer.parseInt(input.get(processedLines));
        for (int i = routesStartLine; i < routesStartLine + routesCount; i++) {
            String[] cities = input.get(i).split(" ");
            City cityFrom = test.getCityByName(cities[0]);
            City cityTo = test.getCityByName(cities[1]);
            test.addRoute(cityFrom, cityTo);
            processedLines++;
        }
        return processedLines;
    }
}