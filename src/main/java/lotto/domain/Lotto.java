package lotto.domain;

import lotto.util.LottoNumber;
import lotto.generator.LottoGenerator;
import lotto.util.InputParser;

import java.util.*;

public class Lotto {

    private static final int PICK = 6;

    private Set<LottoNumber> lottoNumbers;

    private Lotto(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != PICK) {
            throw new RuntimeException();
        }

        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto of(LottoGenerator generator) {
        return new Lotto(generator.generate());
    }

    public static Lotto of(String input) {
        List<String> tokens = InputParser.splitByComma(input);
        List<Integer> numbers = InputParser.toInts(tokens);
        return Lotto.of(numbers.toArray(new Integer[numbers.size()]));
    }

    public static Lotto of(Integer... input) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            lottoNumbers.add(LottoNumber.of(input[i]));
        }
        return new Lotto(lottoNumbers);
    }

    public int match(Lotto target) {
        int matchCount = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            matchCount += target.contains(lottoNumber) ? 1 : 0;
        }
        return matchCount;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
