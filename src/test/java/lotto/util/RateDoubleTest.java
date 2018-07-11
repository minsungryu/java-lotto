package lotto.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RateDoubleTest {

    @Test
    public void doubleValueRate() {
        assertThat(new RateDouble(3.24).doubleValue()).isEqualTo(3.2);
    }

    @Test
    public void stringRate() {
        assertThat(new RateDouble("12.345").doubleValue()).isEqualTo(12.3);
    }

    @Test
    public void rateToString() {
        assertThat(new RateDouble(3.141592).toString()).isEqualTo("3.1");
        assertThat(new RateDouble(3.141592).doubleValue()).isEqualTo(3.1);
    }

}
