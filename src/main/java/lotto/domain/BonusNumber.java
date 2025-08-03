package lotto.domain;

import lotto.validation.BonusNumberValidation;

import java.util.List;

public class BonusNumber {
    
    private final int bonusNumber;
    
    public BonusNumber(List<Integer> winningNumbers, int bonusNumber) {
        BonusNumberValidation bonusNumberValidation = new BonusNumberValidation();
        bonusNumberValidation.isValidRange(bonusNumber);
        bonusNumberValidation.isDuplicated(winningNumbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}