package CorrectBracketExpression.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;
import implemica.CorrectBracketExpression.impl.InputServiceImpl;
import implemica.CorrectBracketExpression.service.InputService;

public class InputServiceImplTest {
    private static final String VALID_NUMBER = "10";
    private static final String INVALID_ZERO_NUMBER = "0";
    private static final String INVALID_NEGATIVE_NUMBER = "-1";
    private static final String INVALID_NUMBER_TYPE = "Hello World!";
    private static InputService inputService;

    @Test
    public void readInt_validInput() {
        //arrange
        ByteArrayInputStream input = new ByteArrayInputStream(VALID_NUMBER.getBytes());
        System.setIn(input);
        inputService = new InputServiceImpl();
        int expected = Integer.parseInt(VALID_NUMBER);

        //act
        int actual = inputService.readInt();

        //assert
        assertEquals(expected, actual);
    }

    @Test
    void readInt_invalidZeroInput() {
        //arrange
        ByteArrayInputStream input = new ByteArrayInputStream(INVALID_ZERO_NUMBER.getBytes());
        System.setIn(input);
        inputService = new InputServiceImpl();

        //act & assert
        assertThrows(RuntimeException.class, inputService::readInt,
                "Method must throw an exception if data is invalid negative number");
    }

    @Test
    void readInt_invalidNegativeInput() {
        //arrange
        ByteArrayInputStream input = new ByteArrayInputStream(INVALID_NEGATIVE_NUMBER.getBytes());
        System.setIn(input);
        inputService = new InputServiceImpl();

        //act & assert
        assertThrows(RuntimeException.class, inputService::readInt,
                "Method must throw an exception if data is invalid negative number.");
    }

    @Test
    void readInt_InvalidTypeInput() {
        //arrange
        ByteArrayInputStream input = new ByteArrayInputStream(INVALID_NUMBER_TYPE.getBytes());
        System.setIn(input);
        inputService = new InputServiceImpl();

        //act & assert
        assertThrows(InputMismatchException.class, inputService::readInt,
                "Method must throw an exception if data is invalid number type.");
    }
}