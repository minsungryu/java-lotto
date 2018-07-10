package lotto.generator;

import lotto.util.LottoNumber;

import java.util.*;

public class RandomLottoGenerator implements LottoGenerator {

    private List<LottoNumber> lottoNumber;

    public RandomLottoGenerator() {
        lottoNumber = new ArrayList<>();
        for (int i = LottoNumber.MIN; i <= LottoNumber.MAX; i++) {
            lottoNumber.add(LottoNumber.of(i));
        }
    }

    @Override
    public Set<LottoNumber> generate() {
        Collections.shuffle(lottoNumber);
        return new TreeSet<>(lottoNumber.subList(0, 6));
    }

    @Override
    public String toString() {
        String generated = generate().toString();
        return generated.substring(1, generated.length() - 1);
    }

}
