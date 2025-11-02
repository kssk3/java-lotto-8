package lotto.domain;

import java.util.Objects;
import lotto.error.LottoGameException;

public class LottoRound {

    private static final int MAX_TICKET_COUNT = 20;
    private static final int MIN_TICKET_COUNT = 1;

    private final int ticketCount;

    public LottoRound(int round) {
        validateRound(round);
        this.ticketCount = round;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    private void validateRound(int round) {
        if(round < MIN_TICKET_COUNT || round > MAX_TICKET_COUNT) {
            throw new IllegalArgumentException(LottoGameException.PREFIX);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoRound that = (LottoRound) o;
        return ticketCount == that.ticketCount;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ticketCount);
    }
}
