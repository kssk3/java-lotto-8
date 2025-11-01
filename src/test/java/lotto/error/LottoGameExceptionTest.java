package lotto.error;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoGameExceptionTest {

    @Test
    void invalidInput() {
        final RuntimeException result = LottoGameException.invalidInput("메세지");
        assertThat(result).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoGameException.PREFIX);
    }

    @Test
    void invalidStatus() {
        final RuntimeException result = LottoGameException.invalidStatus("상태");
        assertThat(result).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LottoGameException.PREFIX);
    }

}