package Tests;

import java.util.Scanner;

/**
 * The first task for Implemica
 * * @author Alexander N.
 */

public class ImplemicaTask1 {

    //start
    public static void main(String[] args) {

        int n = new Scanner(System.in).nextInt();

        char[] str = new char[2 * n];

        printParenthesis(str, n);

        System.out.println("Number of correct bracket expressions for " + n + " = " + solution(n));
    }

    // Print all combinations of balanced brackets and store the number of "(" and ")"
    static void _printParenthesis(char str[], int pos, int n, int open, int close) {

        if (close == n) {

            // print all combinations
            for (int i = 0; i < str.length; i++)
                System.out.print(str[i]);
            System.out.println();
            return;

        } else {

            if (open > close) {
                str[pos] = ')';
                _printParenthesis(str, pos + 1, n, open,
                        close + 1);
            }

            if (open < n) {
                str[pos] = '(';
                _printParenthesis(str, pos + 1, n, open + 1,
                        close);
            }
        }
    }

    // wrapper
    static void printParenthesis(char str[], int n) {

        if (n > 0)
            _printParenthesis(str, 0, n, 0, 0);
        return;
    }

    // walculate the number of correct bracket expressions. The result of the work is called Catalan numbers
    private static int solution(int n) {

        if (n == 0)
            return 1;

        else {
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += solution(i) * solution(n - 1 - i);
            }
            return count;
        }
    }
}