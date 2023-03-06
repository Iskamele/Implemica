package implemica.FindShortestPath.model;

import java.util.HashMap;
import java.util.Map;

public class City {
    private final int id;
    private final String name;
    private final Map<City, Integer> neighbors;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
        neighbors = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<City, Integer> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(City neighbor, int cost) {
        neighbors.put(neighbor, cost);
    }
}
