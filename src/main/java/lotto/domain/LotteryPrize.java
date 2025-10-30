package lotto.domain;


import java.util.Arrays;

public enum LotteryPrize {
    JACKPOT(6, false, 2_000_000_000, "6개 일치"),
    SECOND(5, true, 30_000_000, "5개 일치"),
    THIRD(5, false, 1_500_000, "5개 일치"),
    FORTH(4, false, 50_000, "4개 일치"),
    FIFTH(3, false, 5_000, "3개 일치"),
    NONE(0, false, 0, "꽝!");

    private final Integer matchCount;
    private final boolean bonusMatch;
    private final Integer prize;
    private final String description;

    LotteryPrize(Integer matchCount, boolean bonusMatch, Integer prize, String description) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
        this.description = description;
    }

    public LotteryPrize from(int matchCount, boolean bonusMatch) {
        // 5개 맞춤 + 보너스까지 일치하면 2등
        if (this.matchCount == 5 && bonusMatch) {
            return SECOND;
        }
        // 5개 맞춤 + 보너스 일치하지 않을 경우 3등
        if (this.matchCount == 5 && !bonusMatch) {
            return THIRD;
        }

        return Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public Integer getMatchCount() {
        return matchCount;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public Integer getPrize() {
        return prize;
    }

    public String getDescription() {
        return description;
    }
}
