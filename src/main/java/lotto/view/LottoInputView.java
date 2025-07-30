package lotto.view;

import lotto.domain.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoInputView {

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
    
    public List<Integer> preProcessBonusNumber(String number) {
        List<Integer> bonusNumber = new ArrayList<>();
        bonusNumber.add(Integer.parseInt(number));
        
        return bonusNumber;
    }
}