package implemica.CorrectBracketExpression.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import implemica.CorrectBracketExpression.service.BracketCombinationsService;

public class BracketCombinationsServiceImpl implements BracketCombinationsService {
    // adding either an opening or a closing bracket to a current string based on the open and close counts,
    // and calling itself recursively until the current string has a length of 2 * number,
    // at which point it adds the current string to the result list
    @Override
    public List<String> getCombinations(int number) {
        if (number <= 0) {
            return Collections.emptyList();
        }
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