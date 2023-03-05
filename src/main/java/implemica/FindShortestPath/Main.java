package implemica.FindShortestPath;

import java.util.List;
import implemica.FindShortestPath.impl.FileParserServiceImpl;
import implemica.FindShortestPath.impl.FileReaderServiceImpl;
import implemica.FindShortestPath.impl.FileWriterServiceImpl;
import implemica.FindShortestPath.impl.FindShortestPathImpl;
import implemica.FindShortestPath.model.Route;
import implemica.FindShortestPath.model.Test;
import implemica.FindShortestPath.service.FileParserService;
import implemica.FindShortestPath.service.FileReaderService;
import implemica.FindShortestPath.service.FileWriterService;
import implemica.FindShortestPath.service.FindShortestPath;

public class Main {
    private static final String TO_FILE_PATH =
            "src/main/java/implemica/FindShortestPath/output/output.txt";
    private static final String FROM_FILE_PATH =
            "src/main/java/implemica/FindShortestPath/input/input.txt";

    public static void main(String[] args) {
        FileReaderService fileReader = new FileReaderServiceImpl();
        FileParserService fileParser = new FileParserServiceImpl();
        List<String> fileLines = fileReader.readFile(FROM_FILE_PATH);
        List<Test> tests = fileParser.parseInput(fileLines);
        StringBuilder report = new StringBuilder();
        FindShortestPath findShortestPath = new FindShortestPathImpl();
        for (Test test : tests) {
            report.append(String.format("Test %d%n", test.getNumber()));
            for (Route route : test.getRoutes()) {
                report.append(String.format("%s-%s: %s%n",
                        route.getFromCity().getName(),
                        route.getToCity().getName(),
                        findShortestPath.findShortestPath(test, route.getFromCity(), route.getToCity())
                ));
                System.out.println(findShortestPath.findShortestPath(test, route.getFromCity(), route.getToCity()));
            }
            System.out.println();
            if (test != tests.get(tests.size() - 1)) {
                report.append(System.lineSeparator());
            }
        }
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeToFile(report.toString(), TO_FILE_PATH);
    }
}
