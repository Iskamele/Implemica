package implemica.FindShortestPath.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import implemica.FindShortestPath.model.City;
import implemica.FindShortestPath.service.FindShortestPath;
import implemica.FindShortestPath.storage.CitiesStorage;

public class FindShortestPathImpl implements FindShortestPath {
    static int INF = 200000;

    @Override
    public int findShortestPath(City from, City to) {
        Map<City, Integer> distances = new HashMap<>();
        Set<City> unvisited = new HashSet<>(CitiesStorage.getCities());
        CitiesStorage.getCities().forEach(city -> distances.put(city, INF));
        distances.put(from, 0);
        while (!unvisited.isEmpty()) {
            City current = getClosestCity(distances, unvisited);
            unvisited.remove(current);
            if (current == to) {
                break;
            }
            for (Map.Entry<City, Integer> neighborEntry : current.getNeighbors().entrySet()) {
                City neighbor = neighborEntry.getKey();
                int distanceThroughCurrent = distances.get(current) + neighborEntry.getValue();
                if (distanceThroughCurrent < distances.get(neighbor)) {
                    distances.put(neighbor, distanceThroughCurrent);
                }
            }
        }
        return distances.get(to);
    }

    private City getClosestCity(Map<City, Integer> distances, Set<City> unvisited) {
        return unvisited.stream()
                .min(Comparator.comparingInt(distances::get))
                .orElse(null);
    }
}
