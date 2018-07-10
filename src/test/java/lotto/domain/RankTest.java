package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {

    @Test
    public void prizeOf() {
        assertThat(Rank.prizeOf(0)).isEqualTo(0);
        assertThat(Rank.prizeOf(1)).isEqualTo(0);
        assertThat(Rank.prizeOf(2)).isEqualTo(0);
        assertThat(Rank.prizeOf(3)).isEqualTo(5_000);
        assertThat(Rank.prizeOf(4)).isEqualTo(50_000);
        assertThat(Rank.prizeOf(5)).isEqualTo(1_500_000);
        assertThat(Rank.prizeOf(6)).isEqualTo(2_000_000_000);

        assertThat(Rank.prizeOf(0, true)).isEqualTo(0);
        assertThat(Rank.prizeOf(1, true)).isEqualTo(0);
        assertThat(Rank.prizeOf(2, true)).isEqualTo(0);
        assertThat(Rank.prizeOf(3, true)).isEqualTo(5_000);
        assertThat(Rank.prizeOf(4, true)).isEqualTo(50_000);
        assertThat(Rank.prizeOf(5, true)).isEqualTo(30_000_000);
    }

    @Test(expected = RuntimeException.class)
    public void notMakeSense() {
        Rank.of(6, true);
    }

    @Test
    public void of() {
        assertThat(Rank.of(0)).isEqualTo(Rank.FAIL);
        assertThat(Rank.of(1)).isEqualTo(Rank.FAIL);
        assertThat(Rank.of(2)).isEqualTo(Rank.FAIL);
        assertThat(Rank.of(3)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.of(4)).isEqualTo(Rank.FOURTH);
        assertThat(Rank.of(5)).isEqualTo(Rank.THIRD);
        assertThat(Rank.of(5, true)).isEqualTo(Rank.SECOND);
        assertThat(Rank.of(6)).isEqualTo(Rank.FIRST);
    }

}