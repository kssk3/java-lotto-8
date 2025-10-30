package lotto.service;

import lotto.domain.LottoRound;

public class LottoGameService {

    private final LottoInputValidator validator;

    public LottoGameService(LottoInputValidator validator) {
        this.validator = validator;
    }

    public LottoRound createLottoRound(String input) {
        validator.purchaseAmount(input);
        int round = Integer.parseInt(input);
        return new LottoRound(round);
    }

}
