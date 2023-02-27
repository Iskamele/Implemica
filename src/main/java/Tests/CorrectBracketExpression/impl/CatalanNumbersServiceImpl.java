package Tests.CorrectBracketExpression.impl;

import Tests.CorrectBracketExpression.service.CatalanNumbersService;

public class CatalanNumbersServiceImpl implements CatalanNumbersService {
    @Override
    public int getNumber(int number) {
        if (number == 0)
            return 1;
        else {
            int count = 0;
            for (int i = 0; i < number; i++) {
                count += getNumber(i) * getNumber(number - 1 - i);
            }
            return count;
        }
    }
}