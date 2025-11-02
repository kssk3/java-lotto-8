package lotto.domain;


import static org.assertj.core.api.Assertions.*;

import lotto.error.LottoGameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoRoundTest {

    @DisplayName("최소 라운드가 1 이상이면 테스트를 통과합니다.")
    @Test
    void 최소_라운드가_1_이상이면_테스트를_통과합니다() {
        assertThatCode(() -> new LottoRound(1)).doesNotThrowAnyException();
    }

    @DisplayName("최소 라운드가 1 미만이면 예외를 발생합니다.")
    @Test
    void 최소_라운드가_1_미만이면_예외를_발생합니다() {
        assertThatCode(() -> new LottoRound(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoGameException.PREFIX);
    }

    @DisplayName("라운드가 20 이하는 테스트를 통과합니다.")
    @Test
    void 라운드가_20_이하는_테스트를_통과합니다() {
        assertThatCode(() -> new LottoRound(20)).doesNotThrowAnyException();
    }

    @DisplayName("라운드가 20 초과하면 예외를 발생합니다.")
    @Test
    void 라운드가_20_초과하면_예외를_발생합니다() {
        assertThatCode(() -> new LottoRound(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoGameException.PREFIX);
    }
}