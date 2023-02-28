package CorrectBracketExpression;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Tests.CorrectBracketExpression.impl.CatalanNumbersServiceImpl;

public class CatalanNumbersServiceImplTest {
    private CatalanNumbersServiceImpl catalanNumbersService;

    @BeforeEach
    void setUp() {
        catalanNumbersService = new CatalanNumbersServiceImpl();
    }

    @Test
    public void getNumber_inputZero() {
        //arrange
        int test_data = 0;
        int expected = 1;

        //act
        int actual = catalanNumbersService.getNumber(test_data);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getNumber_inputOne() {
        //arrange
        int test_data = 1;
        int expected = 1;

        //act
        int actual = catalanNumbersService.getNumber(test_data);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getNumber_inputTwo() {
        //arrange
        int test_data = 2;
        int expected = 2;

        //act
        int actual = catalanNumbersService.getNumber(test_data);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getNumber_inputThree() {
        //arrange
        int test_data = 3;
        int expected = 5;

        //act
        int actual = catalanNumbersService.getNumber(test_data);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getNumber_inputNine() {
        //arrange
        int test_data = 9;
        int expected = 4862;

        //act
        int actual = catalanNumbersService.getNumber(test_data);

        //assert
        assertEquals(expected, actual);
    }
}