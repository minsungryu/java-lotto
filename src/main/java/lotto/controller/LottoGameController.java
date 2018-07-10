package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.WinLotto;
import lotto.util.LottoNumber;
import lotto.view.LottoView;

public class LottoGameController {

    private LottoGame game;
    private LottoView view;

    public void run() {
        buyLotto();
        printLottoResult();
    }

    private void buyLotto() {
        game.setMoney(view.getNumber("구입금액을 입력해 주세요."));
        buyManualLotto();
        buyMaximumAutoLotto();
        view.printBuyLottoList(game.getLottoList());
    }

    private void buyManualLotto() {
        int manual = view.getNumber("수동으로 구매할 로또 수를 입력해 주세요.");
        view.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manual && game.hasEnoughMoney(); i++) {
            game.buyLotto(view.getLottoNumbers());
        }
    }

    private void buyMaximumAutoLotto() {
        while (game.hasEnoughMoney()) {
            game.buyLotto();
        }
    }

    private void printLottoResult() {
        Lotto lotto = Lotto.of(view.getLottoNumbers("지난 주 당첨 번호를 입력해 주세요."));
        LottoNumber bonus = LottoNumber.of(view.getNumber("보너스 볼을 입력해 주세요."));

        game.setWinLotto(new WinLotto(lotto, bonus));
        view.printGameResult(game.getGameResult());
    }

    public void setGame(LottoGame game) {
        this.game = game;
    }

    public void setView(LottoView view) {
        this.view = view;
    }

}
