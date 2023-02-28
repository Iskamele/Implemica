package Tests.SumOfDigitsInFactorial.impl;

import java.math.BigInteger;
import Tests.SumOfDigitsInFactorial.service.DigitSum;

public class DigitSumImpl implements DigitSum {
    @Override
    public int calculateDigitSum(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) < 0){
            throw new RuntimeException("Number must be >= 0");
        }
        String str = number.toString();
        return str.chars()
                .map(Character::getNumericValue)
                .sum();
    }
}
