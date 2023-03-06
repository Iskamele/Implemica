package FindShortestPath.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import implemica.FindShortestPath.impl.FindShortestPathImpl;
import implemica.FindShortestPath.model.City;
import implemica.FindShortestPath.service.FindShortestPath;

public class FindShortestPathImplTest {
    private static final int INF = 200000;
    private static final City A = new City(1, "A");
    private static final City B = new City(2, "B");
    private static final City C = new City(3, "C");
    private static final City D = new City(4, "D");
    private static final City E = new City(5, "E");
    private static final City F = new City(6, "F");
    private static final City I = new City(7, "I");
    private static final City O = new City(8, "O");
    private FindShortestPath findShortestPath;
    private implemica.FindShortestPath.model.Test test;

    @BeforeEach
    void setUp() {
        findShortestPath = new FindShortestPathImpl();
        test = new implemica.FindShortestPath.model.Test();
    }

    @Test
    public void findShortest_validData() {
        //arrange
        test.addCity(A);
        test.addCity(B);
        test.addCity(C);
        test.addCity(D);
        test.addCity(E);
        test.addCity(F);
        A.addNeighbor(B, 5);
        A.addNeighbor(C, 1);
        B.addNeighbor(C, 2);
        B.addNeighbor(D, 1);
        C.addNeighbor(D, 4);
        C.addNeighbor(E, 8);
        D.addNeighbor(E, 3);
        D.addNeighbor(F, 6);
        E.addNeighbor(F, 2);
        int expected = 10; // A >1> C >4> D >3> E >2> F

        //act
        int actual = findShortestPath.findShortestPath(test, A, F);

        //assert
        assertEquals(expected, actual,
                "Incorrect cost value.");
    }

    @Test
    public void testFindShortestPath_noPath() {
        //arrange
        implemica.FindShortestPath.model.Test test = new implemica.FindShortestPath.model.Test();
        test.addCity(I);
        test.addCity(O);
        I.addNeighbor(O, 1);
        int expected = INF;

        //act
        int actual = findShortestPath.findShortestPath(test, O, I);

        //assert
        assertEquals(expected, actual,
                "The method should return " + expected
                        + " if there is no path between the cities.");
    }
}
