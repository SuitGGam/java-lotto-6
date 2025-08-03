package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.LottoConstants;
import lotto.util.LottoUtil;
import lotto.validation.PriceValidation;

import java.util.*;

public class LottoService {

    public List<Integer>[] runBuy(String pay) {
        LottoUtil lottoUtil = new LottoUtil();
        
        int value = lottoUtil.preProcessPay(pay);
        int count = buyLotto(value);
        List<Integer>[] issueLotto = issueLotto(count);
        
        return issueLotto;
    }
    
    public int[] runConfirm(String winningLotto, String bonusNumber, List<Integer>[] issuedLotties) {
        LottoUtil lottoUtil = new LottoUtil();
        
        List<Integer> winningNumbers = lottoUtil.preProcessWinningLotto(winningLotto);
        int winningBouns = lottoUtil.preProcessBonusNumber(bonusNumber);
        int[] rank = confirmWinning(winningNumbers, winningBouns, issuedLotties);
        
        return rank;
    }
    
    public int buyLotto(int pay) {
        PriceValidation priceValidation = new PriceValidation();
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
    
    public int[] confirmWinning(List<Integer> winningLotto, int bonusNumber, List<Integer>[] issuedLotties) {
        LottoConstants lottoConstants = new LottoConstants();
        int[] rank = new int[lottoConstants.LOTTO_RANK];

        Set<Integer> winningSet = new HashSet<>(winningLotto);

        for (List<Integer> lotto : issuedLotties) {
            int sameCount = 0;
            boolean sameBonus = false;

            for (Integer num : lotto) {
                if (winningSet.contains(num)) sameCount++;
                if (num == bonusNumber) sameBonus = true;
            }

            if (sameCount == 6) rank[4]++;
            else if (sameCount == 5 && sameBonus) rank[3]++;
            else if (sameCount >= 3) rank[sameCount - 3]++;
        }
        
        return rank;
    }
    
    public long compileStatistics(int[] rank) {
        if (rank.length != 5) throw new IllegalArgumentException("[ERROR] 모든 등수에 대한 결과가 넘어오지 않았습니다.");
        
        LottoConstants lottoConstants = new LottoConstants();
        
        long[] price = {5000L, 50000L, 1500000L, 30000000L, 2000000000L};
        long totalWinning = 0L;
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