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

    public LottoRound createRoundFromAmout(final String input) {
            validator.validatePurchaseAmount(input);
            int round = Integer.parseInt(input) / Constants.LOTTO_TICKET_PRICE;
            return new LottoRound(round);
    }

    public List<Integer> parseWinningNumbers(final String input) {
        validator.validateUniqueWinningNumbers(input);
        return Arrays.stream(input.split(DelimiterConstants.COMMA))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public int parserBonusNumber(final List<Integer> numbers, final String input) {
        validator.ensureBonusNumberNotInWinning(numbers, input);
        return Integer.parseInt(input);
    }

}
