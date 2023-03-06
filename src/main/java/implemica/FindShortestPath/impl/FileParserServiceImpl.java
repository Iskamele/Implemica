package implemica.FindShortestPath.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import implemica.FindShortestPath.model.City;
import implemica.FindShortestPath.model.Test;
import implemica.FindShortestPath.service.FileParserService;

public class FileParserServiceImpl implements FileParserService {
    private static final int TESTS_COUNT_INDEX = 0;
    private static final int START_LINE_INDEX = 1;
    private static final String DATA_REGEX = " ";
    private static final int MAX_TESTS = 10;
    private static final int MAX_CITIES = 10000;
    private static final int MAX_PATHS_TO_FIND = 100;
    private int processedLines = START_LINE_INDEX;
    private int testIndex = 1;
    private final Map<Integer, List<String>> neighborsMap = new HashMap<>();

    // parsing the input and creates a list of Test object
    @Override
    public List<Test> parseInput(List<String> input) {
        int testsNumber = Integer.parseInt(input.get(TESTS_COUNT_INDEX));
        if (testsNumber > MAX_TESTS) {
            throw new IllegalArgumentException("The number of tests must be <= " + MAX_TESTS);
        }
        return IntStream.range(0, testsNumber)
                .mapToObj(i -> createTest(input))
                .collect(Collectors.toList());
    }

    // creating a Test object by adding cities, neighbors, and routes
    // we focus on processedLines, which will show how many lines we have already processed
    private Test createTest(List<String> input) {
        Test test = new Test();
        addCities(input, test);
        addNeighbors(test);
        addRoutes(input, test);
        test.setNumber(testIndex++);
        processedLines++;
        return test;
    }

    // adding cities to the test and populates the neighborsMap
    // store data about neighbors in NeighborsMap in order to process them further
    private void addCities(List<String> input, Test test) {
        int countCities = Integer.parseInt(input.get(processedLines++));
        if (countCities > MAX_CITIES) {
            throw new IllegalArgumentException("The number of cities must be <= " + MAX_CITIES);
        }
        int cityId = 1;
        while (countCities-- > 0 && processedLines < input.size()) {
            String cityName = input.get(processedLines);
            int currentCityNeighbors = Integer.parseInt(input.get(processedLines + 1));
            List<String> currentCityRoad = input.subList(processedLines + 2,
                    processedLines + currentCityNeighbors + 2);
            neighborsMap.put(cityId, currentCityRoad);
            test.addCity(new City(cityId++, cityName));
            processedLines += currentCityNeighbors + 2;
        }
    }

    // adding neighbors to the cities
    private void addNeighbors(Test test) {
        for (Map.Entry<Integer, List<String>> entry : neighborsMap.entrySet()) {
            for (String value : entry.getValue()) {
                String[] cityIdAndCost = value.split(DATA_REGEX);
                int neighborId = Integer.parseInt(cityIdAndCost[0]);
                int neighborCost = Integer.parseInt(cityIdAndCost[1]);
                City neighbor = test.getCityById(neighborId);
                test.getCityById(entry.getKey()).addNeighbor(neighbor, neighborCost);
            }
        }
    }

    // adding routes to the test
    private void addRoutes(List<String> input, Test test) {
        int routesStartLine = processedLines + 1;
        int routesCount = Integer.parseInt(input.get(processedLines));
        if (routesCount > MAX_PATHS_TO_FIND) {
            throw new IllegalArgumentException("The number of paths to find  must be <= "
                    + MAX_PATHS_TO_FIND);
        }
        for (int i = routesStartLine; i < routesStartLine + routesCount; i++) {
            String[] cities = input.get(i).split(DATA_REGEX);
            City cityFrom = test.getCityByName(cities[0]);
            City cityTo = test.getCityByName(cities[1]);
            test.addRoute(cityFrom, cityTo);
            processedLines++;
        }
    }
}