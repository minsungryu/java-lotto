package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.GameResult;
import lotto.dto.LottoList;
import lotto.util.PositiveNumber;
import lotto.util.RateDouble;

import java.io.*;
import java.util.Arrays;
import java.util.Map;

public class LottoConsoleView implements LottoView {

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private String readLine() {
        try {
            return br.readLine();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public int getNumber() {
        return new PositiveNumber(readLine()).intValue();
    }

    @Override
    public int getNumber(String message) {
        println(message);
        return getNumber();
    }

    @Override
    public String getLottoNumbers() {
        return readLine();
    }

    @Override
    public String getLottoNumbers(String message) {
        println(message);
        return getLottoNumbers();
    }

    @Override
    public void print(String message) {
        try {
            bw.write(message);
            bw.flush();
        } catch (Exception e) {
            println(e.getMessage());
        }
    }

    @Override
    public void println(String message) {
        print(message + '\n');
    }

    @Override
    public void printBuyLottoList(LottoList lottoDTO) {
        println(lottoDTO.getLottoList().size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoDTO.getLottoList()) {
            println(lotto.toString());
        }
    }

    @Override
    public void printGameResult(GameResult gameResult) {
        printStatistics(gameResult.getStatistics());
        printRate(gameResult.getRate());
    }

    private void printStatistics(Map<Rank, Integer> statistics) {
        println("당첨 통계");
        println("---------");

        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.FAIL))
                .forEach(rank -> println(String.format("%s - %d개", rank, statistics.get(rank))));
    }

    private void printRate(RateDouble rate) {
        println("총 수익률은 " + rate + "%입니다.");
    }

}
