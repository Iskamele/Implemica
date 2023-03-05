package implemica.FindShortestPath;

import java.util.List;
import java.util.Map;
import implemica.FindShortestPath.impl.FileParserServiceImpl;
import implemica.FindShortestPath.impl.FileReaderServiceImpl;
import implemica.FindShortestPath.impl.FileWriterServiceImpl;
import implemica.FindShortestPath.impl.FindShortestPathImpl;
import implemica.FindShortestPath.model.City;
import implemica.FindShortestPath.model.Test;
import implemica.FindShortestPath.service.FileParserService;
import implemica.FindShortestPath.service.FileReaderService;
import implemica.FindShortestPath.service.FileWriterService;
import implemica.FindShortestPath.service.FindShortestPath;

public class Main {
    private static final String TO_FILE_PATH =
            "src/main/java/implemica/FindShortestPath/output/output.txt";

    public static void main(String[] args) {
        String filePath = "src/main/java/implemica/FindShortestPath/input/input.txt";
        FileReaderService fileReader = new FileReaderServiceImpl();
        FileParserService fileParser = new FileParserServiceImpl();
        List<String> fileLines = fileReader.readFile(filePath);

        List<Test> tests = fileParser.parseInput(fileLines);

        StringBuilder report = new StringBuilder();
        FindShortestPath findShortestPath = new FindShortestPathImpl();
        for (Test test : tests) {
            for (Map.Entry<City, City> entry : test.getRoutes().entrySet()) {
                report.append(entry.getKey().getName());
                report.append("-");
                report.append(entry.getValue().getName());
                report.append(": ");
                report.append(findShortestPath.findShortestPath(test, entry.getKey(), entry.getValue()));
                report.append(System.lineSeparator());
                System.out.println(findShortestPath.findShortestPath(test, entry.getKey(), entry.getValue()));
            }
        }
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report.toString(), TO_FILE_PATH);
    }
}
