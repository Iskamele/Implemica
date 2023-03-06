package implemica.CorrectBracketExpression;

import java.util.List;
import implemica.CorrectBracketExpression.impl.BracketCombinationsServiceImpl;
import implemica.CorrectBracketExpression.impl.CatalanNumbersServiceImpl;
import implemica.CorrectBracketExpression.impl.InputServiceImpl;
import implemica.CorrectBracketExpression.service.BracketCombinationsService;
import implemica.CorrectBracketExpression.service.CatalanNumbersService;
import implemica.CorrectBracketExpression.service.InputService;

public class Main {

    public static void main(String[] args) {
        InputService inputService = new InputServiceImpl();
        BracketCombinationsService combinationsService = new BracketCombinationsServiceImpl();
        CatalanNumbersService catalanNumbersService = new CatalanNumbersServiceImpl();

        int number = inputService.readInt();

        List<String> combinations = combinationsService.getCombinations(number);
        System.out.println("Combinations: ");
        combinations.forEach(System.out::println);

        int catalanNumber = catalanNumbersService.getNumber(number);
        System.out.println("Number of correct bracket expressions for " + number + " = " + catalanNumber);
    }
}
