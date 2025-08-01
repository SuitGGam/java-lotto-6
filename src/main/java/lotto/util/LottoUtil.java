package lotto.util;

import lotto.domain.BonusNumber;
import lotto.domain.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoUtil {
    
    public int preProcessPay(String pay) {
        pay = pay.replaceAll(",", "");
        pay = pay.replaceAll("원", "");
        
        int value = Integer.parseInt(pay);
        
        return value;
    }
    
    public List<Integer> preProcessWinningLotto(String numbers) {
        numbers = numbers.replaceAll(" ", "");
        String[] winningNumbers = numbers.split(",");
        
        List<Integer> winningLotto = new ArrayList<>();
        for (int i = 0; i < LottoConstants.LOTTO_NUMBER_COUNT; i++) {
            winningLotto.add(Integer.parseInt(winningNumbers[i]));
        }
        
        return winningLotto;
    }
    
    public int preProcessBonusNumber(String number) {
        int bonusNumber = Integer.parseInt(number);
        
        return bonusNumber;
    }
}