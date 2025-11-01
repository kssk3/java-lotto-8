package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LotteryPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResults;
import lotto.domain.LottoRound;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.service.LottoGameService;
import lotto.utils.Constants;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameController {

    private final LottoGameService lottoGameService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameController(LottoGameService service, InputView inputView, OutputView outputView) {
        this.lottoGameService = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoGame lottoGame = initializeGame();
        showLottoGame(lottoGame);
        WinningLotto winningLotto = createWinningLotto();
        displayResult(lottoGame, winningLotto);
    }

    private LottoGame initializeGame() {
        LottoRound lottoRound = getLottoRound();
        outputView.printLottoPurchaseCount(lottoRound.getRound());
        return new LottoGame(new Lottos(), lottoRound);
    }

    private void showLottoGame(LottoGame lottoGame) {
        lottoGame.playLotto();
        outputView.printLottoGame(lottoGame.getLottos());
    }

    private LottoRound getLottoRound() {
        while (true) {
            try {
                this.outputView.printRequestPurchaseAmount();
                String input = inputView.readLine();
                return this.lottoGameService.createLottoRound(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                this.outputView.printWinNumbers();
                String input = this.inputView.readLine();
                outputView.printNewLine();
                return this.lottoGameService.createWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber(final List<Integer> winningNumbers) {
        while (true) {
            try {
                this.outputView.printBonusNumber();
                String input = this.inputView.readLine();
                outputView.printNewLine();
                return this.lottoGameService.createBonusNumber(winningNumbers, input);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoResults findLotteryPrizeAndGetResults(LottoGame lottoGame, WinningLotto winningLotto) {
        List<LotteryPrize> matchLottoResults = findMatchResults(lottoGame, winningLotto);
        return new LottoResults(matchLottoResults);
    }

    private static List<LotteryPrize> findMatchResults(LottoGame lottoGame, WinningLotto winningLotto) {
        List<LotteryPrize> matchLottoResults = new ArrayList<>();

        Lottos lottos = lottoGame.getLottos();
        for (Lotto lotto : lottos.getLottos()) {
            int count = (int) lotto.getNumbers().stream()
                    .filter(winningLotto.getNumbers()::contains)
                    .count();

            boolean bonusMatch = lotto.getNumbers().stream()
                    .anyMatch(number -> number == winningLotto.getBonusNumber());

            matchLottoResults.add(LotteryPrize.from(count, bonusMatch));
        }
        return matchLottoResults;
    }

    private void displayResult(LottoGame lottoGame, WinningLotto winningLotto) {
        LottoResults lottoResults = findLotteryPrizeAndGetResults(lottoGame, winningLotto);
        int purchaseAmount = lottoGame.getLottoRound().getRound() * Constants.LOTTO_TICKET_PRICE;
        outputView.printWinningStatistics(lottoResults);
        outputView.printTotalAmount(lottoResults, purchaseAmount);
    }
}
