package Tests;

import java.util.Optional;
import java.util.Scanner;

public class Implemica_task_1 {
    public static void main(String[] args) {

        System.out.println("Enter a mathematical expression containing \"(\" and \")\": ");
        Implemica_task_1.validParentheses(new Scanner(System.in).nextLine());
}

    public static Optional<Integer> validParentheses(String parens) {
        int check = 0; // a variable that will be an indicator of compliance with the conditions of the task
        int amount = 0; // number of correct bracket expressions

        // solution start
        for (int i = 0; i < parens.length(); i++) {


            // check if the bracket expression starts with ")"
            if (check < 0) {
                amount--;
                break;
            }

            if (parens.charAt(i) == '(') { // when finding "(", increase the counter by 1
                check++;
            } else if (parens.charAt(i) == ')') { // respectively ")" reduces it by 1
                check--;
                amount++; // count the number of correct bracket expressions
            }
        }

        // check if all bracket expressions have been closed
        if (check != 0) {
            System.out.println("The bracket expression is incorrect");
            return Optional.empty();
        }

        // we return the answer
        System.out.println("Number of correct expressions: " + amount);
        return Optional.of(amount);
    }
}