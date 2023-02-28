package Tests.SumOfDigitsInFactorial.impl;

import java.math.BigInteger;
import Tests.SumOfDigitsInFactorial.service.Factorial;

public class FactorialImpl implements Factorial {
    @Override
    public BigInteger calculateFactorial(int number) {
        if (number < 0) {
            throw new RuntimeException("Number must be >= 0");
        }
        if (number == 0) {
            return BigInteger.ONE;
        } else {
            return BigInteger.valueOf(number).multiply(calculateFactorial(number - 1));
        }
    }
}
