package CorrectBracketExpression.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import implemica.CorrectBracketExpression.impl.CatalanNumbersServiceImpl;

public class CatalanNumbersServiceImplTest {
    private CatalanNumbersServiceImpl catalanNumbersService;

    @BeforeEach
    void setUp() {
        catalanNumbersService = new CatalanNumbersServiceImpl();
    }

    @Test
    public void getNumber_inputZero() {
        //arrange
        int input = 0;
        int expected = 1;

        //act
        int actual = catalanNumbersService.getNumber(input);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getNumber_inputOne() {
        //arrange
        int input = 1;
        int expected = 1;

        //act
        int actual = catalanNumbersService.getNumber(input);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getNumber_inputTwo() {
        //arrange
        int input = 2;
        int expected = 2;

        //act
        int actual = catalanNumbersService.getNumber(input);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getNumber_inputThree() {
        //arrange
        int input = 3;
        int expected = 5;

        //act
        int actual = catalanNumbersService.getNumber(input);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getNumber_inputNine() {
        //arrange
        int input = 9;
        int expected = 4862;

        //act
        int actual = catalanNumbersService.getNumber(input);

        //assert
        assertEquals(expected, actual);
    }
}