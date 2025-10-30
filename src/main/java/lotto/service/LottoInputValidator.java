package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import lotto.error.LottoGameException;
import lotto.utils.DelimiterConstants;

public class LottoInputValidator {

    private static final int MINIMUM_PRICE = 1000;

    public void purchaseAmount(String input) {
        Integer value = validateAndParseInt(input);
        if (value < MINIMUM_PRICE) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "1,000원 이하의 금액은 구입할 수 없습니다. " + value);
        }
        int lestCost = value % 1000;
        if (lestCost != 0) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "1,000원 단위로 입력해주세요. 현재 구매굼액 " + value);
        }
    }

    public void duplicateNumber(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(DelimiterConstants.COMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        Set<Integer> numbers = new TreeSet<>(winningNumbers);
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "중복된 수를 입력할 수 없습니다.");
        }
    }

    public void duplicateBonusNumber(List<Integer> numbers, String input) {
        int value = validateAndParseInt(input);
        if (numbers.contains(value)) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "이미 중복된 번호가 있습니다. " + value + " 다른 번호를 입력해주세요.");
        }
    }

    private int validateAndParseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "숫자값을 입력해주세요.");
        }
    }

}
