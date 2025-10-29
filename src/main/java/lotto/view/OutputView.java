package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printRequestPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoPurchaseCount(int value) {
        printNewLine();
        System.out.println(value + "개를 구매했습니다.");
        printNewLine();
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
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

    private void printNewLine() {System.out.println();}



}
