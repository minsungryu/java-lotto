package lotto.util;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class InputParserTest {

    @Test
    public void splitByComma() {
        List<String> parsedList = InputParser.splitByComma("1, 2, 3, 4, 5, 6");
        assertThat(parsedList).contains("1", "2", "3", "4", "5", "6");
    }

    @Test
    public void toInts() {
        List<String> strList = new ArrayList<>(Arrays.asList("1", "2"));
        assertThat(InputParser.toInts(strList)).containsExactly(1, 2);
    }

}