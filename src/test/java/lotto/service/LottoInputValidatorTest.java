package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import lotto.error.LottoGameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoInputValidatorTest {

    @DisplayName("중복된 번호가 있으면 예외를 발생한다.")
    @Test
    void 중복된_번호가_있으면_예외를_발생한다() {
        final LottoInputValidator validator = new LottoInputValidator();
        assertThatThrownBy(() -> validator.validateUniqueWinningNumbers("1,2,3,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoGameException.PREFIX);

    }

    @DisplayName("중복된_번호가_없으면_테스트를_통과한다")
    @Test
    void 중복된_번호가_없으면_테스트를_통과한다() {
        final LottoInputValidator validator = new LottoInputValidator();
        assertSimpleTest(() -> validator.validateUniqueWinningNumbers("1,2,3,4,5,6"));
    }

    @DisplayName("번호가 1부터 45사이의 값이 아닐경우 예외를 발생한다.")
    @Test
    void 번호가_1부터_45사이의_값이_아닐경우_예외를_발생한다() {
        final LottoInputValidator validator = new LottoInputValidator();
        assertThatThrownBy(() -> validator.validateUniqueWinningNumbers("11,22,33,44,55,66"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoGameException.PREFIX);
    }

}