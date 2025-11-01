package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoRound;
import lotto.utils.Constants;
import lotto.utils.DelimiterConstants;

public class LottoGameService {

    private final LottoInputValidator validator;

    public LottoGameService(LottoInputValidator validator) {
        this.validator = validator;
    }

    public LottoRound createLottoRound(final String input) {
            validator.purchaseAmount(input);
            int round = Integer.parseInt(input) / Constants.LOTTO_TICKET_PRICE;
            return new LottoRound(round);
    }

    public List<Integer> createWinningNumbers(final String input) {
        validator.validateDuplicateNumber(input);
        return Arrays.stream(input.split(DelimiterConstants.COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int createBonusNumber(final List<Integer> numbers, final String input) {
        validator.duplicateBonusNumber(numbers, input);
        return Integer.parseInt(input);
    }

}
