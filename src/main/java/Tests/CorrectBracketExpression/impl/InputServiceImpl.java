package Tests.CorrectBracketExpression.impl;

import java.util.InputMismatchException;
import java.util.Scanner;
import Tests.CorrectBracketExpression.service.InputService;

public class InputServiceImpl implements InputService {
    private final Scanner scanner;

    public InputServiceImpl() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int readInt() {
        System.out.println("Enter positive number: ");
        if (!scanner.hasNextInt()) {
            throw new InputMismatchException("Incorrect number type.");
        }
        int number = scanner.nextInt();
        if (number <= 0) {
            throw new RuntimeException("The number must be greater than 0.");
        }
        return number;
    }
}