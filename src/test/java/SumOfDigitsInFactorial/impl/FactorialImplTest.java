package SumOfDigitsInFactorial.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import implemica.SumOfDigitsInFactorial.impl.FactorialImpl;
import implemica.SumOfDigitsInFactorial.service.Factorial;

public class FactorialImplTest {
    private Factorial factorial;

    @BeforeEach
    void setUp() {
        factorial = new FactorialImpl();
    }

    @Test
    void calculateFactorial_inputZero() {
        //arrange
        int input = 0;
        BigInteger expected = BigInteger.ONE;
        //act
        BigInteger actual = factorial.calculateFactorial(input);
        //assert
        assertEquals(expected, actual, "Factorial of " + input + " should be " + expected);
    }

    @Test
    void calculateFactorial_inputFive() {
        //arrange
        int input = 5;
        BigInteger expected = BigInteger.valueOf(120);

        //act
        BigInteger actual = factorial.calculateFactorial(input);

        //assert
        assertEquals(expected, actual, "Factorial of " + input + " should be " + expected);
    }

    @Test
    void calculateFactorial_inputNine() {
        //arrange
        int input = 9;
        BigInteger expected = BigInteger.valueOf(362880);

        //act
        BigInteger actual = factorial.calculateFactorial(input);

        //assert
        assertEquals(expected, actual, "Factorial of " + input + " should be " + expected);
    }

    @Test
    void calculateFactorial_inputNegativeNumber() {
        //arrange
        int test_data = -5;

        //act & assert
        assertThrows(RuntimeException.class, () -> factorial.calculateFactorial(test_data),
                "Method must throw an exception if input number is negative");
    }
}
