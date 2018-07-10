package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.WinLotto;

import java.util.*;

public class LottoList {

    private List<Lotto> lottoList;
    private WinLotto winLotto;

    public LottoList() {
        this.lottoList = new ArrayList<>();
    }

    public void addLotto(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int size() {
        return lottoList.size();
    }

    public WinLotto getWinLotto() {
        return this.winLotto;
    }

    public void setWinLotto(WinLotto winLotto) {
        this.winLotto = winLotto;
    }

}
