package lotto.domain;

import lotto.util.LottoNumber;
import lotto.generator.LottoGenerator;
import lotto.util.InputParser;

import java.util.*;
import java.util.stream.Collectors;

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
        return Lotto.of(Arrays.stream(InputParser.splitByComma(input)).map(Integer::parseInt).toArray(Integer[]::new));
    }

    public static Lotto of(Integer... input) {
        return new Lotto(Arrays.stream(input).map(LottoNumber::of).collect(Collectors.toSet()));
    }

    public int match(Lotto target) {
        return (int) lottoNumbers.stream().filter(target::contains).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

}
