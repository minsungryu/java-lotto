package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinLottoTest {

    private WinLotto winLotto;

    @Before
    public void setUp() {
        this.winLotto = new WinLotto("1, 2, 3, 4, 5, 6", "7");
    }

    @Test
    public void match() {
        List<Lotto> sample = Arrays.asList(
            Lotto.of("11, 12, 13, 14, 15, 16"),
            Lotto.of("1, 12, 13, 14, 15, 16"),
            Lotto.of("1, 2, 13, 14, 15, 16"),
            Lotto.of("1, 2, 3, 14, 15, 16"),
            Lotto.of("1, 2, 3, 4, 15, 16"),
            Lotto.of("1, 2, 3, 4, 5, 16"),
            Lotto.of("1, 2, 3, 4, 5, 6")
        );

        IntStream.range(0, sample.size()).forEach(i -> assertThat(winLotto.match(sample.get(i))).isEqualTo(i));
    }

    @Test
    public void bonusMatch() {
        assertThat(winLotto.bonusMatch(Lotto.of("11, 12, 13, 14, 15, 16"))).isFalse();
        assertThat(winLotto.bonusMatch(Lotto.of("7, 12, 13, 14, 15, 16"))).isTrue();
    }

}
