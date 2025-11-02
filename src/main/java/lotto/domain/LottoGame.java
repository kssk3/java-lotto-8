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
        this.currentRound = Constants.INITIAL_COUNT;
    }

    @Override
    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(Constants.LOTTO_MIN_NUMBER, Constants.LOTTO_MAX_NUMBER, Constants.LOTTO_NUMBER_COUNT);
    }

    public void generateLottos() {
        do {
            generateLotto();
        } while (!isFinished());
    }

    private void generateLotto() {
        try {
            lottos.add(new Lotto(generateLottoNumbers()));
            incrementRound();
        } catch (IllegalArgumentException e) {
            e.getMessage();
        }
    }

    private void incrementRound() {
        currentRound++;
    }

    private boolean isFinished() {
        return currentRound == lottoRound.getTicketCount();
    }

    public Lottos getLottos() {
        return lottos;
    }

    public LottoRound getLottoRound() {
        return lottoRound;
    }
}
