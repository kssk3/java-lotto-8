package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.error.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

    @DisplayName("당첨 번호와 보너스 번호가 중복하지 않을 경우 테스틑 통과한다")
    @Test
    void 당첨_번호와_보너스_번호가_중복하지_않을_경우_테스트는_통과한다() {
        assertThatCode(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7))
                .doesNotThrowAnyException();
    }

    @DisplayName("당첨 번호와 보너스 번호가 중복할 경우 예외를 발생한다")
    @Test
    void 당첨_번호와_보너스_번호가_중복할_경우_예외를_발생한다() {
        final List<Integer>  winningLotto = List.of(1, 2, 3, 4, 5, 6);
        Integer bonusNumber = 6;
        assertThatThrownBy(() -> new WinningLotto(winningLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoGameException.PREFIX);
    }
}