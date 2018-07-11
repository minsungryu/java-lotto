package lotto.util;

import java.util.Arrays;

public class InputParser {

    private static final String COMMA = ",";

    public static String[] splitByComma(String input) {
        return Arrays.stream(input.split(COMMA)).map(String::trim).toArray(String[]::new);
    }

}
