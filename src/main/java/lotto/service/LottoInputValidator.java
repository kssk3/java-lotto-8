package lotto.service;

import lotto.error.LottoGameException;

public class LottoInputValidator {

    private static final int MINIMUM_PRICE = 1000;

    public void purchaseAmount(String input) {
        Integer value = validateAndParseInt(input);
        if(value < MINIMUM_PRICE) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "1,000원 이하의 금액은 구입할 수 없습니다.");
        }
        int lestCost = value % 1000;
        if(lestCost != 0){
            throw new IllegalArgumentException(LottoGameException.PREFIX + "1,000원 단위로 입력해주세요. 현재 구매굼액 " + value);
        }
    }

    private int validateAndParseInt(String input) {
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "숫자값을 입력해주세요.");
        }
    }
}
