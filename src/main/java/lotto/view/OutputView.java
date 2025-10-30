package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoRound;
import lotto.domain.Lottos;

public class OutputView {

    public void printRequestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoPurchaseCount(final int value) {
        printNewLine();
        System.out.println(value + "개를 구매했습니다.");
    }

    public void printLottoGame(Lottos lottos) {
        for(Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
        printNewLine();
    }

    public void printBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    private void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public void printNewLine() {System.out.println();}



}
