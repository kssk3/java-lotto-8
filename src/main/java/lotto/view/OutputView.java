package lotto.view;

import java.util.List;
import lotto.domain.LotteryPrize;
import lotto.domain.Lotto;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;

public class OutputView {

    public void printRequestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoPurchaseCount(final int value) {
        printNewLine();
        System.out.println(value + "개를 구매했습니다.");
    }

    public void printPurchasedLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        printNewLine();
    }

    public void printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printRequestWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printWinningStatistics(LottoResults lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("---");

        List<LotteryPrize> prizesInOrder = lottoResults.getPrizesInOrder();
        for (LotteryPrize prize : prizesInOrder) {
            int count = lottoResults.getCountByPrize(prize);
            printPrizeResult(prize, count);
        }
    }

    private static void printPrizeResult(LotteryPrize prize, int count) {
        if (prize == LotteryPrize.SECOND) {
            System.out.println(
                    prize.getDescription() + ", 보너스 볼 일치 (" + String.format("%,d", prize.getPrize()) + "원)" + " - " + count + "개");
            return;
        }
        System.out.println(
                prize.getDescription() + " (" + String.format("%,d", prize.getPrize()) + "원)" + " - " + count + "개");
    }

    public void printProfitRate(LottoResults lottoResults, int purchaseAmount) {
        double result = lottoResults.calculateReturnRate(purchaseAmount);
        System.out.println("총 수익률은 " + String.format("%,.1f", result) + "%입니다.");
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

}