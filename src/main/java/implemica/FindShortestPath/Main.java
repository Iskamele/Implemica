package implemica.FindShortestPath;

import java.util.List;
import java.util.Map;
import implemica.FindShortestPath.impl.FileParserServiceImpl;
import implemica.FindShortestPath.impl.FileReaderServiceImpl;
import implemica.FindShortestPath.impl.FindShortestPathImpl;
import implemica.FindShortestPath.model.City;
import implemica.FindShortestPath.service.FileParserService;
import implemica.FindShortestPath.service.FileReaderService;
import implemica.FindShortestPath.service.FindShortestPath;
import implemica.FindShortestPath.storage.CitiesStorage;
import implemica.FindShortestPath.storage.RoutesStorage;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/implemica/FindShortestPath/input/input.txt";
        FileReaderService fileReader = new FileReaderServiceImpl();
        FileParserService fileParser = new FileParserServiceImpl();
        List<String> fileLines = fileReader.readFile(filePath);
        fileParser.parseInput(fileLines);
        for (int i = 0; i < CitiesStorage.getCities().size(); i++) {
            System.out.println(CitiesStorage.getCities().get(i).toString());
        }
        for (Map.Entry<City, City> entry : RoutesStorage.getRoutes().entrySet()) {
            System.out.println(entry.getKey().getName() + "-" + entry.getValue().getName());
        }
        FindShortestPath findShortestPath = new FindShortestPathImpl();
        for (Map.Entry<City, City> entry : RoutesStorage.getRoutes().entrySet()) {
            System.out.println(findShortestPath.findShortestPath(entry.getKey(), entry.getValue()));
        }
    }
}
