package Tests.CorrectBracketExpression.impl;

import java.util.ArrayList;
import java.util.List;
import Tests.CorrectBracketExpression.service.BracketCombinationsService;

public class BracketCombinationsServiceImpl implements BracketCombinationsService {
    @Override
    public List<String> getCombinations(int number) {
        List<String> result = new ArrayList<>();
        generateCombinations(result, "", 0, 0, number);
        return result;
    }

    private void generateCombinations(List<String> result, String current, int open, int close, int number) {
        if (current.length() == 2 * number) {
            result.add(current);
        } else {
            if (open < number) {
                generateCombinations(result, current + "(", open + 1, close, number);
            }
            if (close < open) {
                generateCombinations(result, current + ")", open, close + 1, number);
            }
        }
    }
}