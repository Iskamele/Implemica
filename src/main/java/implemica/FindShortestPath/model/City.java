package implemica.FindShortestPath.model;

import java.util.HashMap;
import java.util.Map;

public class City {
    private int id = 0;
    private String name;
    private Map<Integer, Integer> neighbors;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
        neighbors = new HashMap<>();
    }

    public City() {
        neighbors = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addNeighbor(Integer neighborId, int cost) {
        neighbors.put(neighborId, cost);
    }

    public String getName() {
        return name;
    }

    public Map<Integer, Integer> getNeighbors() {
        return neighbors;
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
