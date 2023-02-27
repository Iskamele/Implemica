package Tests.CorrectBracketExpression.impl;

import java.util.ArrayList;
import java.util.List;
import Tests.CorrectBracketExpression.service.BracketCombinationsService;

public class BracketCombinationsServiceImpl implements BracketCombinationsService {

    @Override
    public List<String> getCombinations(int number) {
        List<String> result = new ArrayList<>();
        char[] str = new char[2 * number];
        combinations(str, 0, number, 0, 0, result);
        return result;
    }

    static void combinations(char[] str, int pos, int n, int open, int close, List<String> result) {
        if (close == n) {
            result.add(new String(str));
        } else {
            if (open > close) {
                str[pos] = ')';
                combinations(str, pos + 1, n, open, close + 1, result);
            }
            if (open < n) {
                str[pos] = '(';
                combinations(str, pos + 1, n, open + 1, close, result);
            }
        }
    }
}