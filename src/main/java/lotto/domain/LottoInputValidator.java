package lotto.domain;

import lotto.error.LottoGameException;

public class LottoInputValidator {

    public Integer purchaseAmount(String input) {
        Integer value = parseInt(input);
        int lestCost = value % 1000;
        if(lestCost != 0){
            throw new IllegalArgumentException(LottoGameException.PREFIX + "1,000원 단위로 입력해주세요. 현재 구매굼액 " + value);
        }

        return value;
    }

    public Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "숫자값을 입력해주세요.");
        }
    }
}
