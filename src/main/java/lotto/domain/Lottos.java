package lotto.domain;

import java.util.LinkedList;
import java.util.List;
import lotto.error.LottoGameException;

public class Lottos {

    private final List<Lotto> tickets;

    public Lottos() {
        this.tickets = new LinkedList<>();
    }

    public void add(Lotto lotto) {
        this.tickets.add(lotto);
    }

    public List<Lotto> getAll() {
        return tickets;
    }

    private void validateLottos() {
        if(this.tickets == null || this.tickets.isEmpty()) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "소지하고 있는 로또가 없습니다.");
        }
    }

}
