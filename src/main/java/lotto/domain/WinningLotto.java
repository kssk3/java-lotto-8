package lotto.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private final List<Integer> numbers;
    private final Integer bonus;

    public WinningLotto(List<Integer> numbers, Integer bonus) {
        this.numbers = new LinkedList<>(numbers);
        this.bonus = bonus;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Integer getBonus() {
        return bonus;
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
