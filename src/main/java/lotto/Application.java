package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGameService;
import lotto.service.LottoInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGameController lottoGameController =
                new LottoGameController(new LottoGameService(new LottoInputValidator()), new InputView(), new OutputView());


        lottoGameController.run();
    }
}
