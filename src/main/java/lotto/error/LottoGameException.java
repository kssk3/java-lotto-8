package lotto.error;

public class LottoGameException {

    public static final String PREFIX = "[ERROR] ";

    private LottoGameException() {
        throw new UnsupportedOperationException("생성자를 생성할 수 없습니다.");
    }

    public RuntimeException invalidInput(String input) {
        return new IllegalArgumentException(PREFIX + input);
    }

    public RuntimeException invalidStatus(String input) {
        return new IllegalArgumentException(PREFIX + input);
    }
}
