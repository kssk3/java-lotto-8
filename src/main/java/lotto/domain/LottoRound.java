package lotto.domain;

import java.util.Objects;
import lotto.error.LottoGameException;

public class LottoRound {

    private static final int MAXIMUM_TICKET = 20;
    private static final int MINIMUM_TICKET = 1;

    private final int round;

    public LottoRound(int round) {
        validateRound(round);
        this.round = round;
    }

    public int getRound() {
        return round;
    }

    private void validateRound(int round) {
        if(round < MINIMUM_TICKET|| round > MAXIMUM_TICKET) {
            throw new IllegalArgumentException(LottoGameException.PREFIX);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoRound that = (LottoRound) o;
        return round == that.round;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(round);
    }
}
