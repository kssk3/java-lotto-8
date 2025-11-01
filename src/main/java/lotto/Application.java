package lotto;

import lotto.controller.LottoGameController;
import lotto.service.LottoGameService;
import lotto.service.LottoInputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        LottoGameService lottoGameService = new LottoGameService(new LottoInputValidator());
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        try{
            LottoGameController lottoGameController = new LottoGameController(lottoGameService, inputView, outputView);
            lottoGameController.run();
        }catch (IllegalArgumentException e){
            outputView.printErrorMessage(e.getMessage());
        }
    }
}
