package SumOfDigitsInFactorial.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import implemica.SumOfDigitsInFactorial.impl.DigitSumImpl;
import implemica.SumOfDigitsInFactorial.service.DigitSum;

public class DigitSumImplTest {
    private DigitSum digitSum;

    @BeforeEach
    void setUp() {
        digitSum = new DigitSumImpl();
    }

    @Test
    void calculateDigitSum_inputFiftyFive() {
        //arrange
        int input = 55;
        int excepted = 10;

        //act
        int actual = digitSum.calculateDigitSum(BigInteger.valueOf(input));

        //assert
        assertEquals(excepted, actual);
    }

    @Test
    void calculateDigitSum_inputFactorialOfTen() {
        //arrange
        BigInteger factorial = BigInteger.ONE;
        for (int i = 1; i <= 10; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        int excepted = 27;

        //act
        int actual = digitSum.calculateDigitSum(factorial);

        //assert
        assertEquals(excepted, actual);
    }

    @Test
    void calculateDigitSum_inputZero() {
        // implementation does not depend on the factorial
        //arrange
        BigInteger number = BigInteger.ZERO;
        int excepted = 0;

        //act
        int actual = digitSum.calculateDigitSum(number);

        //assert
        assertEquals(excepted, actual);
    }

    @Test
    void calculateDigitSum_inputNegativeNumber() {
        //arrange
        BigInteger number = BigInteger.valueOf(-123);

        //act & assert
        assertThrows(RuntimeException.class, () -> digitSum.calculateDigitSum(number),
                "Method must throw an exception if data is invalid negative number");
    }
}
