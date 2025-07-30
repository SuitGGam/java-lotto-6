package lotto;

import lotto.domain.LottoConstants;
import lotto.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Application {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        LottoService lottoService = new LottoService();
        LottoConstants  lottoConstants  = new LottoConstants();
        LottoInputView  lottoInputView  = new LottoInputView();
        LottoOutputView lottoOutputView = new LottoOutputView();
        
        lottoInputView.inputProcessPay();
        String pay = br.readLine();
        System.out.println();
        List<Integer>[] issuedLotties = lottoService.runBuy(pay);
        lottoOutputView.outputProcessIssuedLotties(issuedLotties);
        lottoInputView.inputProcessWinningLotto();
        String winningLotto = br.readLine();
        System.out.println();
        lottoInputView.inputProcessBonusNumber();
        String bonusNumber = br.readLine();
        System.out.println();
        int[] rank = lottoService.runConfirm(winningLotto, bonusNumber, issuedLotties);
        lottoOutputView.outputProcessStatistics(issuedLotties.length * lottoConstants.LOTTO_PRICE, rank);
        
        br.close();
    }
}