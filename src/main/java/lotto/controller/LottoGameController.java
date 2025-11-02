package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
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
        generateAndDisplayLottos(lottoGame);
        WinningLotto winningLotto = createWinningLotto();
        displayResult(lottoGame, winningLotto);
    }

    private <T> T retryOnException(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private LottoGame initializeGame() {
        return retryOnException(() -> {
            LottoRound lottoRound = getLottoRound();
            outputView.printLottoPurchaseCount(lottoRound.getTicketCount());
            return new LottoGame(new Lottos(), lottoRound);
        });
    }

    private void generateAndDisplayLottos(LottoGame lottoGame) {
        lottoGame.generateLottos();
        outputView.printPurchasedLottos(lottoGame.getLottos());
    }

    private LottoRound getLottoRound() {
        return retryOnException(() -> {
            this.outputView.printRequestPurchaseAmount();
            String input = inputView.readLine();
            return this.lottoGameService.createRoundFromAmout(input);
        });
    }

    private WinningLotto createWinningLotto() {
        List<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);
        return new WinningLotto(winningNumbers, bonusNumber);
    }

    private List<Integer> getWinningNumbers() {
        return retryOnException(() -> {
            this.outputView.printRequestWinningNumbers();
            String input = this.inputView.readLine();
            outputView.printNewLine();
            return this.lottoGameService.parseWinningNumbers(input);
        });
    }

    private int getBonusNumber(final List<Integer> winningNumbers) {
        return retryOnException(() -> {
            this.outputView.printBonusNumber();
            String input = this.inputView.readLine();
            outputView.printNewLine();
            return this.lottoGameService.parserBonusNumber(winningNumbers, input);
        });
    }

    private LottoResults createLottoResults(LottoGame lottoGame, WinningLotto winningLotto) {
        List<LotteryPrize> matchLottoResults = matchLottosWithWinning(lottoGame, winningLotto);
        return new LottoResults(matchLottoResults);
    }

    private static List<LotteryPrize> matchLottosWithWinning(LottoGame lottoGame, WinningLotto winningLotto) {
        List<LotteryPrize> matchLottoResults = new ArrayList<>();

        Lottos lottos = lottoGame.getLottos();
        for (Lotto lotto : lottos.getAll()) {
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
        LottoResults lottoResults = createLottoResults(lottoGame, winningLotto);
        int purchaseAmount = lottoGame.getLottoRound().getTicketCount() * Constants.LOTTO_TICKET_PRICE;
        outputView.printWinningStatistics(lottoResults);
        outputView.printProfitRate(lottoResults, purchaseAmount);
    }
}
