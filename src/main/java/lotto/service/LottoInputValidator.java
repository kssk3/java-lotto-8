package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import lotto.error.LottoGameException;
import lotto.utils.Constants;
import lotto.utils.DelimiterConstants;

public class LottoInputValidator {

    private static final int REST_COST = 0;

    public void validatePurchaseAmount(String input) throws IllegalArgumentException{
        Integer value = parseIntegerInput(input);
        if (value < Constants.LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "1,000원 이하의 금액은 구입할 수 없습니다. " + value);
        }
        int restCost = value % Constants.LOTTO_TICKET_PRICE;
        if (restCost != REST_COST) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "1,000원 단위로 입력해주세요. 현재 구매굼액 " + value);
        }
    }

    public void validateUniqueWinningNumbers(String input) {
        List<Integer> winningNumbers = splitAndParseNumbers(input);
        validateNumbersInRange(winningNumbers);
        Set<Integer> numbers = new TreeSet<>(winningNumbers);
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "중복된 수를 입력할 수 없습니다.");
        }
    }

    public void ensureBonusNumberNotInWinning(List<Integer> numbers, String input) {
        int value = parseIntegerInput(input);
        if (numbers.contains(value)) {
            throw new IllegalArgumentException(
                    LottoGameException.PREFIX + "이미 중복된 번호가 있습니다. " + value + " 다른 번호를 입력해주세요.");
        }
    }

    public static void validateNumbersInRange(List<Integer> winningNumbers) {
        for (Integer number : winningNumbers) {
            if (number < Constants.LOTTO_MIN_NUMBER || number > Constants.LOTTO_MAX_NUMBER) {
                throw new IllegalArgumentException(LottoGameException.PREFIX + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public static List<Integer> splitAndParseNumbers(String input) {
        return Arrays.stream(input.split(DelimiterConstants.COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int parseIntegerInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "숫자값을 입력해주세요.");
        }
    }

}
