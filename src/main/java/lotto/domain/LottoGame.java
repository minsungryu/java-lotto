package lotto.domain;

import lotto.dto.GameResult;
import lotto.dto.LottoList;
import lotto.generator.RandomLottoGenerator;
import lotto.util.RateDouble;

import java.util.Map;
import java.util.TreeMap;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private LottoList lottoList;
    private int money;

    public LottoGame() {
        this.lottoList = new LottoList();
        this.money = 0;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setWinLotto(WinLotto winLotto) {
        lottoList.setWinLotto(winLotto);
    }

    public boolean hasEnoughMoney() {
        return LOTTO_PRICE <= money;
    }

    public void buyLotto() {
        buyLotto(new RandomLottoGenerator().toString());
    }

    public void buyLotto(String numbers) {
        if (!hasEnoughMoney()) {
            throw new RuntimeException();
        }
        lottoList.addLotto(Lotto.of(numbers));
        money -= LOTTO_PRICE;
    }

    public Map<Rank, Integer> getStatistics() {
        Map<Rank, Integer> statisticsMap = initStatisticsMap();

        WinLotto winLotto = lottoList.getWinLotto();
        for (Lotto lotto : lottoList.getLottoList()) {
            int matchCount = winLotto.match(lotto);
            boolean bonusMatch = winLotto.bonusMatch(lotto);
            Rank rank = Rank.of(matchCount, bonusMatch);
            statisticsMap.put(rank, statisticsMap.get(rank) + 1);
        }

        return statisticsMap;
    }

    public Map<Rank, Integer> initStatisticsMap() {
        Map<Rank, Integer> statisticsMap = new TreeMap<>();
        for (Rank rank : Rank.values()) {
            statisticsMap.put(rank, 0);
        }
        return statisticsMap;
    }

    public RateDouble getEarningRate() {
        int investMoney = getInvestMoney();
        int totalPrize = getTotalPrize();
        return new RateDouble((double) totalPrize * 100 / investMoney);
    }

    public int getInvestMoney() {
        return lottoList.getLottoList().size() * LOTTO_PRICE;
    }

    public int getTotalPrize() {
        WinLotto winLotto = lottoList.getWinLotto();

        int totalPrize = 0;
        for (Lotto lotto : lottoList.getLottoList()) {
            int matchCount = winLotto.match(lotto);
            boolean bonusMatch = winLotto.bonusMatch(lotto);
            totalPrize += Rank.prizeOf(matchCount, bonusMatch);
        }

        return totalPrize;
    }

    public LottoList getLottoList() {
        return lottoList;
    }

    public GameResult getGameResult() {
        return new GameResult(getStatistics(), getEarningRate());
    }

}
