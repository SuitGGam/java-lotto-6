package lotto.domain;

import lotto.validation.LottoNumbersValidation;

import java.util.List;

public class WinningLotto {
    
    private final List<Integer> winningNumbers;
    
    public WinningLotto(List<Integer> winningNumbers) {
        LottoNumbersValidation lottoNumbersValidation = new LottoNumbersValidation();
        lottoNumbersValidation.areSix(winningNumbers);
        lottoNumbersValidation.areValidRange(winningNumbers);
        lottoNumbersValidation.areDuplicated(winningNumbers);
        this.winningNumbers = winningNumbers;
    }
}