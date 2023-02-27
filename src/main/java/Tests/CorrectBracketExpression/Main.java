package Tests.CorrectBracketExpression;

import java.util.List;
import Tests.CorrectBracketExpression.impl.BracketCombinationsServiceImpl;
import Tests.CorrectBracketExpression.impl.CatalanNumbersServiceImpl;
import Tests.CorrectBracketExpression.impl.InputServiceImpl;
import Tests.CorrectBracketExpression.service.BracketCombinationsService;
import Tests.CorrectBracketExpression.service.CatalanNumbersService;
import Tests.CorrectBracketExpression.service.InputService;

public class Main {
    public static void main(String[] args) {
        InputService inputService = new InputServiceImpl();
        BracketCombinationsService combinationsService = new BracketCombinationsServiceImpl();
        CatalanNumbersService catalanNumbersService = new CatalanNumbersServiceImpl();

        int n = inputService.readInt();

        List<String> combinations = combinationsService.getCombinations(n);
        System.out.println("Combinations: ");
        combinations.forEach(System.out::println);

        int catalanNumber = catalanNumbersService.getNumber(n);
        System.out.println("Number of correct bracket expressions for " + n + " = " + catalanNumber);
    }
}
