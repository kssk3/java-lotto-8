package lotto.domain;

import java.util.Objects;

public class LottoRound {

    private final int round;

    public LottoRound(int round) {
        this.round = round;
    }

    public int getRound() {
        return round;
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
