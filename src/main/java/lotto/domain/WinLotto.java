package lotto.domain;

import lotto.util.LottoNumber;

public class WinLotto {

    private Lotto lotto;
    private LottoNumber bonus;

    public WinLotto(String lottoNumbers, String bonusNumber) {
        this(Lotto.of(lottoNumbers), LottoNumber.of(bonusNumber));
    }

    public WinLotto(Lotto lotto, LottoNumber bonus) {
        if (lotto.contains(bonus)) {
            throw new RuntimeException();
        }
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public int match(Lotto target) {
        return target.match(lotto);
    }

    public boolean bonusMatch(Lotto target) {
        return target.contains(bonus);
    }

}
