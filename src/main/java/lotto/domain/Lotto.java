package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import lotto.error.LottoGameException;

public class Lotto implements LottoMachine {

    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int PICK_COUNT = 6;

    private final Set<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = new TreeSet<>();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != PICK_COUNT) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public void run() {
        List<Integer> results = Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, PICK_COUNT);
        numbers.addAll(results);
    }

    public Set<Integer> getNumbers() {
        return numbers;
    }
}
