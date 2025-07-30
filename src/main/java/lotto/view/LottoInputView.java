package lotto.view;

import lotto.domain.LottoConstants;

import java.util.ArrayList;
import java.util.List;

public class LottoInputView {
    
    public void inputProcessPay() {
        System.out.println("구입금액을 입력해 주세요.");
    }
    
    public void inputProcessWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }
    
    public void inputProcessBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }
    
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