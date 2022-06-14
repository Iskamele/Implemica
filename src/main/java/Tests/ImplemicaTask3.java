package Tests;

import java.math.BigInteger;

/**
 * The first task for Implemica
 * * @author Alexander N.
 */

public class ImplemicaTask3 {
    public static void main(String[] args) {

        int value = 100;
        int length; // declare a variable where will store the length of the factorial

        // calculating factorial and writing it to BigInteger
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = 2; i <= value; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println("Factorial of " + value + " is " + factorial);

        // initialize variable "length"
        length = String.valueOf(factorial).length();

        // declare and initialize a variable that will store the remainder of the division
        BigInteger total = BigInteger.valueOf(0);

        // solution start
        for (int i = 0; i < length; i++) {
            BigInteger d = factorial.mod(BigInteger.valueOf(10));
            factorial = factorial.divide(BigInteger.valueOf(10));
            total = total.add(d);
        }
        System.out.println("Sum of digits is: " + total);
    }
}