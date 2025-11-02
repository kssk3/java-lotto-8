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
        this.currentRound = Constants.INITIAL_ROUND_COUNT;
    }

    @Override
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_NUMBER_COUNT);
    }

    public void generateAllLottos() {
        do {
            generateSingleLotto();
        } while (!isFinished());
    }

    private void generateSingleLotto() {
        try {
            lottos.addLotto(new Lotto(generateLottoNumbers()));
            incrementCurrentRound();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    private void incrementCurrentRound() {
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
