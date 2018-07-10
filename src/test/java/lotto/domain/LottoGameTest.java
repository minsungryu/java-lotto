package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    private LottoGame game;

    @Before
    public void setUp() {
        game = new LottoGame();
        game.setWinLotto(new WinLotto("1, 2, 3, 4, 5, 6", "7"));
    }

    @Test
    public void enoughMoney() {
        game.setMoney(1100);
        assertThat(game.hasEnoughMoney()).isTrue();
    }

    @Test
    public void notEnoughMoney() {
        game.setMoney(900);
        assertThat(game.hasEnoughMoney()).isFalse();
    }

    @Test
    public void buyLottoWithEnoughMoney() {
        game.setMoney(1000);
        game.buyLotto();
        assertThat(game.getLottoList().size()).isOne();
    }

    @Test(expected = RuntimeException.class)
    public void buyLottoWithoutMoney() {
        game.setMoney(0);
        game.buyLotto();
    }

    @Test
    public void getStatistics() {
        game.setMoney(1000);
        game.buyLotto("1, 2, 3, 4, 5, 6");

        Map<Rank, Integer> rank = new HashMap<>();
        rank.put(Rank.FAIL, 0);
        rank.put(Rank.FIFTH, 0);
        rank.put(Rank.FOURTH, 0);
        rank.put(Rank.THIRD, 0);
        rank.put(Rank.SECOND, 0);
        rank.put(Rank.FIRST, 1);

        assertThat(game.getStatistics()).isEqualTo(rank);
    }

    @Test
    public void getEarningRate() {
        game.setMoney(2000);
        game.buyLotto("11, 12, 13, 14, 15, 16");
        game.buyLotto("1, 2, 3, 24, 25, 26");

        assertThat(game.getEarningRate().doubleValue()).isEqualTo(250.0);
    }

    @Test
    public void investMoney() {
        game.setMoney(2400);
        game.buyLotto();
        assertThat(game.getInvestMoney()).isEqualTo(1000);
    }

    @Test
    public void getTotalPrize() {
        game.setMoney(7000);
        game.buyLotto("1, 2, 3, 4, 5, 6");
        game.buyLotto("1, 2, 3, 4, 5, 16");
        game.buyLotto("1, 2, 3, 4, 15, 16");
        game.buyLotto("1, 2, 3, 14, 15, 16");
        game.buyLotto("1, 2, 13, 14, 15, 16");
        game.buyLotto("1, 12, 13, 14, 15, 16");
        game.buyLotto("11, 12, 13, 14, 15, 16");

        assertThat(game.getTotalPrize()).isEqualTo(2001555000);
    }

}
