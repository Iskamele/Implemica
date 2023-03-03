package implemica.FindShortestPath.model;

import java.util.HashMap;
import java.util.Map;

public class City {
    private final int id;
    private final String name;
    private final Map<Integer, Integer> neighbors;

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

    public Map<Integer, Integer> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Integer neighborId, int cost) {
        neighbors.put(neighborId, cost);
    }

    @Override
    public String toString() {
        return "City ["
                + "name: " + name
                + ", id: " + id
                + ", neighbors id=cost: " + neighbors
                + "]";
    }
}
