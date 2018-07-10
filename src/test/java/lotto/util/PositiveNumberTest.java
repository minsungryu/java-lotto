package lotto.util;

import org.junit.Test;

public class PositiveNumberTest {

    @Test (expected = RuntimeException.class)
    public void init() {
        new PositiveNumber(-1);
    }

    @Test (expected = RuntimeException.class)
    public void initString() {
        new PositiveNumber("a");
    }

}