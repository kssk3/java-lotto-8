package lotto.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import lotto.utils.Constants;

public class LottoResults {

    private List<LotteryPrize> lotteryPrizes;

    public LottoResults(List<LotteryPrize> lotteryPrizes) {
        this.lotteryPrizes = lotteryPrizes;
    }

    public List<LotteryPrize> getPrizesInOrder() {
        return Arrays.stream(LotteryPrize.values())
                .filter(prize -> prize != LotteryPrize.NONE)
                .sorted(Comparator.comparing(LotteryPrize::getPrize))
                .toList();
    }

    public int getCountByPrize(LotteryPrize otherPrize) {
        return (int) lotteryPrizes.stream()
                .filter(prize -> prize.equals(otherPrize))
                .count();
    }

    public int getTotalPrizeAmount() {
        return lotteryPrizes.stream()
                .mapToInt(LotteryPrize::getPrize)
                .sum();
    }

    public double calculateReturnRate(int purchasePrice) {
        return (double) getTotalPrizeAmount() / purchasePrice * Constants.PERCENTAGE_MULTIPLIER;
    }

}
