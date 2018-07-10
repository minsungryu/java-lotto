package lotto.dto;

import lotto.domain.Rank;
import lotto.util.RateDouble;

import java.util.Map;

public class GameResult {

    private Map<Rank, Integer> statistics;
    private RateDouble rate;

    public GameResult(Map<Rank, Integer> statistics, RateDouble rate) {
        this.statistics = statistics;
        this.rate = rate;
    }

    public Map<Rank, Integer> getStatistics() {
        return statistics;
    }

    public RateDouble getRate() {
        return rate;
    }

}
