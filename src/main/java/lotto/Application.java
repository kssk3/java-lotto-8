package lotto;

import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoRound;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        output.printRequestPurchaseAmount();
        String inputs = input.readLine();

        int value = Integer.parseInt(inputs);
        int lottoCount = value / 1000;

        output.printLottoPurchaseCount(lottoCount);
        LottoRound lottoRound = new LottoRound(lottoCount);
        Lottos lottos = new Lottos();
        LottoGame lottoGame = new LottoGame(lottos, lottoRound);
        lottoGame.playLotto();

        output.printLottos(lottos.getLottos());
        output.printWinNumbers();
        String str = input.readLine();
        System.out.println();
        output.printBonusNumber();
        String bonus = input.readLine();
        System.out.println();

        String wingNumber = str + bonus;
        List<Integer> wingResult = Arrays.stream(wingNumber.split(",")).map(String::trim).map(Integer::parseInt).toList();
        System.out.println("당첨 통계");
        System.out.println("---");

    }

}
