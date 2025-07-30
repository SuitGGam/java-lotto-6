package lotto.domain;

import lotto.validation.BonusNumberValidation;

import java.util.List;

public class BonusNumber {
    
    private final List<Integer> bonusNumber;
    
    public BonusNumber(List<Integer> winningNumbers, List<Integer> bonusNumber) {
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();
        bonusNumberValidation.isOne(bonusNumber);
        bonusNumberValidation.isValidRange(bonusNumber);
        bonusNumberValidation.isDuplicated(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}