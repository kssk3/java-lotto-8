package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoGame implements LottoMachine{

    private static final int INIT_LOTTO_ROUNDS = 0;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int LOTTO_PICK_COUNT = 6;

    private Lottos lottos;
    private LottoRound lottoRound;
    private int currentRound;

    public LottoGame(Lottos lottos, LottoRound lottoRound) {
        this.lottos = lottos;
        this.lottoRound = lottoRound;
        this.currentRound = INIT_LOTTO_ROUNDS;
    }

    @Override
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, LOTTO_PICK_COUNT);
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

}
