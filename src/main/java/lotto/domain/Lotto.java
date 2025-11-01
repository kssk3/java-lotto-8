package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import lotto.error.LottoGameException;
import lotto.utils.Constants;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "로또 번호는 6개여야 합니다.");
        }
        if (numbers.size() != new TreeSet<>(numbers).size()) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "로또 번호에 중복된 숫자가 있습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }


}
