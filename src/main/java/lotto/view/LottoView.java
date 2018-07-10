package lotto.view;

import lotto.dto.GameResult;
import lotto.dto.LottoList;

public interface LottoView {

    int getNumber();

    int getNumber(String message);

    String getLottoNumbers();

    String getLottoNumbers(String message);

    void print(String message);

    void println(String message);

    void printBuyLottoList(LottoList lottoList);

    void printGameResult(GameResult gameResult);

}
