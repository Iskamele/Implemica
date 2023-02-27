package Tests.CorrectBracketExpression.impl;

import java.util.Scanner;
import Tests.CorrectBracketExpression.service.InputService;

public class InputServiceImpl implements InputService {
    private final Scanner scanner;

    public InputServiceImpl() {
        scanner = new Scanner(System.in);
    }

    @Override
    public int readInt() {
        System.out.println("Enter number: ");
        return scanner.nextInt();
    }
}