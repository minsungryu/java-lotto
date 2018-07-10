package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static final String COMMA = ",";

    public static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(COMMA)).map(String::trim).collect(Collectors.toList());
    }

    public static List<Integer> toInts(List<String> tokens) {
        return tokens.stream().map(Integer::parseInt).collect(Collectors.toList());
    }

}
