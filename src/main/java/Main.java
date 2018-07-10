import lotto.controller.LottoGameController;
import lotto.domain.LottoGame;
import lotto.view.LottoConsoleView;

public class Main {

    public static void main(String[] args) {
        LottoGameController controller = new LottoGameController();
        controller.setView(new LottoConsoleView());
        controller.setGame(new LottoGame());

        controller.run();
    }

}
