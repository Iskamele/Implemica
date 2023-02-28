package CorrectBracketExpression.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Tests.CorrectBracketExpression.impl.BracketCombinationsServiceImpl;

public class BracketCombinationsServiceImplTest {
    private BracketCombinationsServiceImpl bracketService;

    @BeforeEach
    void setUp() {
        bracketService = new BracketCombinationsServiceImpl();
    }

    @Test
    void getCombinations_inputOne() {
        //arrange
        int input = 1;
        List<String> expected = new ArrayList<>();
        expected.add("()");

        //act
        List<String> actual = bracketService.getCombinations(input);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void getCombinations_inputTwo() {
        //arrange
        int input = 2;
        List<String> expected = new ArrayList<>();
        expected.add("(())");
        expected.add("()()");

        //act
        List<String> actual = bracketService.getCombinations(input);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void getCombinations_inputThree() {
        //arrange
        int input = 3;
        List<String> expected = new ArrayList<>();
        expected.add("((()))");
        expected.add("(()())");
        expected.add("(())()");
        expected.add("()(())");
        expected.add("()()()");

        //act
        List<String> actual = bracketService.getCombinations(input);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void getCombinations_inputZero() {
        //arrange
        int input = 0;
        List<String> expected = Collections.emptyList();

        //act
        List<String> actual = bracketService.getCombinations(input);

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void getCombinations_inputNegativeNumber() {
        //arrange
        int input = -19;
        List<String> expected = Collections.emptyList();

        //act
        List<String> actual = bracketService.getCombinations(input);

        //assert
        assertEquals(expected, actual);
    }
}