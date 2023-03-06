package FindShortestPath.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import implemica.FindShortestPath.impl.FileParserServiceImpl;
import implemica.FindShortestPath.service.FileParserService;

public class FileParserServiceImplTest {
    private static final int MAX_TESTS = 10;
    private static final int MAX_CITIES = 10000;
    private static final int MAX_PATHS_TO_FIND = 100;
    private static final String INCORRECT_CITY_NAME_MESSAGE = "Incorrect city name.";
    private FileParserService fileParserService;
    private List<String> input;

    @BeforeEach
    public void setUp() {
        fileParserService = new FileParserServiceImpl();
        input = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        input.clear();
    }

    @Test
    public void parseInput_validInputDataWithOneTest() {
        //arrange
        input.add("1");
        input.add("4");
        input.add("paris");
        input.add("2");
        input.add("2 3");
        input.add("3 3");
        input.add("marseille");
        input.add("3");
        input.add("1 3");
        input.add("3 8");
        input.add("4 10");
        input.add("lyon");
        input.add("3");
        input.add("1 3");
        input.add("2 8");
        input.add("4 4");
        input.add("toulouse");
        input.add("2");
        input.add("2 10");
        input.add("3 4");
        input.add("2");
        input.add("paris toulouse");
        input.add("marseille lyon");

        //act
        List<implemica.FindShortestPath.model.Test> tests = fileParserService.parseInput(input);

        //assert
        assertEquals(1, tests.size(),
                "Incorrect number of tests.");
        assertEquals("paris", tests.get(0).getCities().get(0).getName(),
                INCORRECT_CITY_NAME_MESSAGE);
        assertEquals("marseille", tests.get(0).getCities().get(1).getName(),
                INCORRECT_CITY_NAME_MESSAGE);
    }

    @Test
    public void parseInput_validInputDataWithSeveralTests() {
        //arrange
        input.add("3");
        input.add("3");
        input.add("paris");
        input.add("2");
        input.add("2 3");
        input.add("3 3");
        input.add("marseille");
        input.add("2");
        input.add("1 3");
        input.add("3 8");
        input.add("lyon");
        input.add("2");
        input.add("1 11");
        input.add("2 8");
        input.add("2");
        input.add("paris lyon");
        input.add("marseille lyon");
        input.add("3");
        input.add("kiyv");
        input.add("1");
        input.add("2 3");
        input.add("lviv");
        input.add("2");
        input.add("1 9");
        input.add("3 8");
        input.add("kharkiv");
        input.add("2");
        input.add("1 4");
        input.add("2 8");
        input.add("1");
        input.add("kiyv kharkiv");
        input.add("3");
        input.add("riga");
        input.add("1");
        input.add("2 1");
        input.add("daugavpils");
        input.add("2");
        input.add("1 1");
        input.add("3 2");
        input.add("jelgava");
        input.add("1");
        input.add("2 2");
        input.add("2");
        input.add("riga daugavpils");
        input.add("daugavpils jelgava");

        //act
        List<implemica.FindShortestPath.model.Test> tests = fileParserService.parseInput(input);

        //assert
        assertEquals(3, tests.size(),
                "Incorrect number of tests.");
        assertEquals("paris", tests.get(0).getCityByName("paris").getName(),
                INCORRECT_CITY_NAME_MESSAGE);
        assertEquals("marseille", tests.get(0).getCityByName("marseille").getName(),
                INCORRECT_CITY_NAME_MESSAGE);
        assertEquals("kiyv", tests.get(1).getCityByName("kiyv").getName(),
                INCORRECT_CITY_NAME_MESSAGE);
        assertEquals("kharkiv", tests.get(1).getCityByName("kharkiv").getName(),
                INCORRECT_CITY_NAME_MESSAGE);
        assertEquals("riga", tests.get(2).getCityByName("riga").getName(),
                INCORRECT_CITY_NAME_MESSAGE);
        assertEquals("daugavpils", tests.get(2).getCityByName("daugavpils").getName(),
                INCORRECT_CITY_NAME_MESSAGE);
        assertEquals(2, tests.get(2).getRoutes().size(),
                "Incorrect number of tests.");
        assertEquals("riga", tests.get(2).getRoutes().get(0).getFromCity().getName(),
                INCORRECT_CITY_NAME_MESSAGE);
        assertEquals("daugavpils", tests.get(2).getRoutes().get(0).getToCity().getName(),
                INCORRECT_CITY_NAME_MESSAGE);

    }

    @Test
    public void parseInput_invalidNumberOfTests() {
        //arrange
        input.add("11");

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> fileParserService.parseInput(input),
                "Method must throw an exception if number of tests > " + MAX_TESTS);
    }

    @Test
    public void parseInput_invalidNumberOfCities() {
        //arrange
        input.add("1");
        input.add("10001");

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> fileParserService.parseInput(input),
                "Method must throw an exception if number of cities > " + MAX_CITIES);
    }

    @Test
    public void parseInput_invalidNumberOfPaths() {
        //arrange
        input.add("1");
        input.add("4");
        input.add("Paris");
        input.add("2");
        input.add("2 3");
        input.add("3 3");
        input.add("Marseille");
        input.add("3");
        input.add("1 3");
        input.add("3 8");
        input.add("4 10");
        input.add("Lyon");
        input.add("3");
        input.add("1 3");
        input.add("2 8");
        input.add("4 4");
        input.add("Toulouse");
        input.add("2");
        input.add("2 10");
        input.add("3 4");
        input.add("101");

        //act & assert
        assertThrows(IllegalArgumentException.class, () -> fileParserService.parseInput(input),
                "Method must throw an exception if number of paths > 100" + MAX_PATHS_TO_FIND);
    }
}