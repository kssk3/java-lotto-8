package lotto.domain;

import java.util.LinkedList;
import java.util.List;
import lotto.error.LottoGameException;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos() {
        this.lottos = new LinkedList<>();
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private void validateLottos() {
        if(this.lottos == null || this.lottos.isEmpty()) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "소지하고 있는 로또가 없습니다.");
        }
    }

}
