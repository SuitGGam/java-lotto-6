package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoConstants;
import lotto.validation.PriceValidation;
import lotto.view.LottoInputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoService {

    public List<Integer>[] runBuy(String pay) {
        LottoInputView lottoInputView = new LottoInputView();
        
        int value = lottoInputView.preProcessPay(pay);
        int count = buyLotto(value);
        List<Integer>[] issueLotto = issueLotto(count);
        
        return issueLotto;
    }
    
    public int[] runConfirm(String winningLotto, String bonusNumber, List<Integer>[] issuedLotties) {
        LottoInputView lottoInputView = new LottoInputView();
        
        List<Integer> winningNumbers = lottoInputView.preProcessWinningLotto(winningLotto);
        List<Integer> winningBouns   = lottoInputView.preProcessBonusNumber(bonusNumber);
        
        int[] rank = confirmWinning(winningNumbers, winningBouns, issuedLotties);
        
        return rank;
    }
    
    public int buyLotto(int pay) {
        PriceValidation priceValidation = new PriceValidation();
        priceValidation.atLeastPay(pay);
        priceValidation.isMultiplesOfThousand(pay);
        int lottiesCount = pay / LottoConstants.LOTTO_PRICE;
        return lottiesCount;
    }
    
    public List<Integer>[] issueLotto(int lottiesCount) {
        List<Integer>[] issuedLotties = new List[lottiesCount];
        for (int i = 0; i < lottiesCount; i++) {
            issuedLotties[i] = new ArrayList<>();
            issuedLotties[i] = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_NUMBER_MIN, LottoConstants.LOTTO_NUMBER_MAX, LottoConstants.LOTTO_NUMBER_COUNT);
            Collections.sort(issuedLotties[i]);
        }
        
        return issuedLotties;
    }
    
    public int[] confirmWinning(List<Integer> winningLotto, List<Integer> bonusNumber, List<Integer>[] issuedLotties) {
        LottoConstants lottoConstants = new LottoConstants();
        int[] rank = new int[lottoConstants.LOTTO_RANK];
        
        for (int i = 0; i < issuedLotties.length; i++) {
            int sameNumbers  = 0;
            int sameBonusNum = 0;
            
            for (int j = 0; j < lottoConstants.LOTTO_NUMBER_COUNT; j++) {
                for (int k = 0; k < lottoConstants.LOTTO_NUMBER_COUNT; k++) {
                    if (winningLotto.get(j) == issuedLotties[i].get(k)) {
                        sameNumbers++;
                        break;
                    }
                    
                    if (bonusNumber.get(0) == issuedLotties[i].get(k)) {
                        sameBonusNum++;
                        break;
                    }
                }
            }
            
            int sumSameNumbers = sameNumbers + sameBonusNum;
            if (sumSameNumbers >= 3) rank[sumSameNumbers - 3]++;
            
            if (sameNumbers == 6) {
                rank[3]--;
                rank[4]++;
            }
        }
        
        return rank;
    }
    
    public long compileStatistics(int[] rank) {
        if (rank.length != 5) throw new IllegalArgumentException("[ERROR] 모든 등수에 대한 결과가 넘어오지 않았습니다.");
        
        LottoConstants lottoConstants = new LottoConstants();
        
        long[] price = {5000, 50000, 1500000, 30000000, 2000000000};
        long totalWinning = 0;
        for (int i = 0; i < lottoConstants.LOTTO_RANK; i++) {
            totalWinning += (long) rank[i] * price[i];
        }
        
        return totalWinning;
    }
    
    public double findTheRateOfReturn(int pay, long totalWinnigs) {
        double theRateOfReturn = (double) totalWinnigs / pay;
        if (theRateOfReturn < 0) throw new IllegalArgumentException("[ERROR] 음수 수익률은 나올 수 없습니다.");
        
        return Math.round(theRateOfReturn * 10 / 10.0);
    }
}