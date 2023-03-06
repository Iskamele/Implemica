package implemica.SumOfDigitsInFactorial;

import java.math.BigInteger;
import implemica.SumOfDigitsInFactorial.impl.DigitSumImpl;
import implemica.SumOfDigitsInFactorial.impl.FactorialImpl;
import implemica.SumOfDigitsInFactorial.service.DigitSum;
import implemica.SumOfDigitsInFactorial.service.Factorial;

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
