package implemica.FindShortestPath.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import implemica.FindShortestPath.model.City;
import implemica.FindShortestPath.service.FindShortestPath;
import implemica.FindShortestPath.storage.CitiesStorage;

public class FindShortestPathImpl implements FindShortestPath {
    @Override
    public int findShortestPath(City from, City to) {
        Map<City, Integer> distances = new HashMap<>();
        Set<City> unvisited = new HashSet<>(CitiesStorage.getCities());
        Map<City, City> previous = new HashMap<>();
        for (City city : CitiesStorage.getCities()) {
            distances.put(city, Integer.MAX_VALUE);
        }
        distances.put(from, 0);
        while (!unvisited.isEmpty()) {
            City current = getClosestCity(distances, unvisited);
            unvisited.remove(current);
            if (current == to) {
                break;
            }
            for (Map.Entry<Integer, Integer> neighborEntry : current.getNeighbors().entrySet()) {
                City neighbor = CitiesStorage.getCities().get(neighborEntry.getKey() - 1);
                int distanceThroughCurrent = distances.get(current) + neighborEntry.getValue();
                if (distanceThroughCurrent < distances.get(neighbor)) {
                    distances.put(neighbor, distanceThroughCurrent);
                    previous.put(neighbor, current);
                }
            }
        }
        return distances.get(to);
    }

    private City getClosestCity(Map<City, Integer> distances, Set<City> unvisited) {
        int minDistance = Integer.MAX_VALUE;
        City closestCity = null;
        for (City city : unvisited) {
            int distance = distances.get(city);
            if (distance < minDistance) {
                minDistance = distance;
                closestCity = city;
            }
        }
        return closestCity;
    }
}
