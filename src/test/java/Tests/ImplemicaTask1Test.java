package Tests;

import org.junit.Assert;
import org.junit.Test;

public class ImplemicaTask1Test {

    @Test
    public void simpleTest() {
        int solution = ImplemicaTask1.solution(3);
        Assert.assertEquals(5, solution);
    }
}