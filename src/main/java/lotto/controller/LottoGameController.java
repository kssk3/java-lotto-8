package lotto.controller;

import lotto.domain.LottoGame;
import lotto.domain.LottoRound;
import lotto.domain.Lottos;
import lotto.service.LottoGameService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoGameService service;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(LottoGameService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoGame lottoGame = initializeGame();
    }

    private LottoGame initializeGame() {
        LottoRound lottoRound = getLottoRound();
        return new LottoGame(new Lottos(), lottoRound);
    }

    private LottoRound getLottoRound() {
        outputView.printRequestPurchaseAmount();
        String input = inputView.readLine();
        return service.createLottoRound(input);
    }
}
