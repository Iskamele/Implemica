package implemica.FindShortestPath.service;

import implemica.FindShortestPath.model.City;
import implemica.FindShortestPath.model.Test;

public interface FindShortestPath {
    int findShortestPath(Test test, City from, City to);
}
