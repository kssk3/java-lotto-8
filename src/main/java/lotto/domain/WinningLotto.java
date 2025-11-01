package lotto.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import lotto.error.LottoGameException;
import lotto.utils.Constants;

public class WinningLotto {

    private final List<Integer> numbers;
    private final Integer bonus;

    public WinningLotto(List<Integer> numbers, Integer bonus) {
        validate(numbers);
        validateContainsBonusNumber(numbers, bonus);
        this.numbers = new LinkedList<>(numbers);
        this.bonus = bonus;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonusNumber() {
        return bonus;
    }

    private void validate(List<Integer> numbers){
        if (Objects.isNull(numbers) || numbers.isEmpty()){
            throw new IllegalArgumentException(LottoGameException.PREFIX + "로또 번호는 입력해주세요");
        }

        if (numbers.size() != Constants.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LottoGameException.PREFIX + "로또 번호는 6개만 입력할 수 있습니다.");
        }
    }

    private void validateContainsBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    LottoGameException.PREFIX + " 당첨 번호와 보너스 번호가 중복될 수 없습니다. " + bonusNumber + " 다른 번호를 입력해주세요.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(numbers, that.numbers) && Objects.equals(bonus, that.bonus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers, bonus);
    }

    @Override
    public String toString() {
        return "winningLotto{" +
                "numbers=" + numbers +
                ", bonus=" + bonus +
                '}';
    }
}
