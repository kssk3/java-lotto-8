package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.utils.Constants;

public class LottoGame implements LottoMachine{

    private final Lottos lottos;
    private final LottoRound lottoRound;
    private int currentRound;

    public LottoGame(Lottos lottos, LottoRound lottoRound) {
        this.lottos = lottos;
        this.lottoRound = lottoRound;
        this.currentRound = Constants.INIT_LOTTO_ROUNDS;
    }

    @Override
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.MINIMUM_NUMBER, Constants.MAXIMUM_NUMBER, Constants.LOTTO_PICK_COUNT);
    }

    public void playLotto() {
        do {
            playLottoGame();
        } while (!isFinished());
    }

    private void playLottoGame() {
        try {
            lottos.addLotto(new Lotto(generateLottoNumbers()));
            addCurrentLottoRound();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    private void addCurrentLottoRound() {
        currentRound++;
    }

    private boolean isFinished() {
        return currentRound == lottoRound.getRound();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public LottoRound getLottoRound() {
        return lottoRound;
    }
}
