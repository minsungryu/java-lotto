package lotto.domain;

import lotto.util.LottoNumber;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private Lotto lotto;

    @Before
    public void setUp() {
        this.lotto = Lotto.of(1, 2, 3, 4, 5, 6);
    }

    @Test(expected = RuntimeException.class)
    public void factoryUnderTest() {
        Lotto.of("1, 2, 3, 4, 5");
    }

    @Test(expected = RuntimeException.class)
    public void factoryOverTest() {
        Lotto.of("1, 2, 3, 4, 5, 6, 7");
    }

    @Test(expected = RuntimeException.class)
    public void mismatchParameter() {
        Lotto.of("a, b, 3, 4, 5, 6");
    }

    @Test
    public void match() {
        Lotto winLotto = Lotto.of(1, 2, 3, 14, 15, 16);
        assertThat(lotto.match(winLotto)).isEqualTo(3);
    }

    @Test
    public void contains() {
        LottoNumber existNumber = LottoNumber.of(1);
        LottoNumber notExistNumber = LottoNumber.of(11);
        assertThat(lotto.contains(existNumber)).isTrue();
        assertThat(lotto.contains(notExistNumber)).isFalse();
    }

    @Test
    public void toStringTest() {
        assertThat(lotto.toString()).isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

}
