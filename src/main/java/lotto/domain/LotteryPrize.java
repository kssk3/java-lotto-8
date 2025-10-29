package lotto.domain;

public enum LotteryPrize {
    JACKPOT(6, "20,000,000,000원"),
    SECOND(5, "30,000,000원"),
    THIRD(5, "1,500,000원"),
    FORTH(4, "50,000원"),
    FIFTH(3, "5,000원"),
    NONE(0, "꽝입니다.");

    private Integer rank;
    private String value;

    LotteryPrize(Integer rank, String value) {
        this.rank = rank;
        this.value = value;
    }
}
