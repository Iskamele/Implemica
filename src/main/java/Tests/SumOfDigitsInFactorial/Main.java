package Tests.SumOfDigitsInFactorial;

import java.math.BigInteger;
import Tests.SumOfDigitsInFactorial.impl.DigitSumImpl;
import Tests.SumOfDigitsInFactorial.impl.FactorialImpl;
import Tests.SumOfDigitsInFactorial.service.DigitSum;
import Tests.SumOfDigitsInFactorial.service.Factorial;

public class Main {

    public static void main(String[] args) {
        int number = 100;
        Factorial factorialService = new FactorialImpl();
        DigitSum digitSumService = new DigitSumImpl();

        BigInteger factorial = factorialService.calculateFactorial(number);
        int digitSum = digitSumService.calculateDigitSum(factorial);

        System.out.println("Sum of digits in " + number + "! = " + digitSum);
    }
}
