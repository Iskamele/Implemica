package implemica.FindShortestPath.service;

import java.util.List;
import implemica.FindShortestPath.model.Test;

public interface FileParserService {
    List<Test> parseInput(List<String> input);
}
