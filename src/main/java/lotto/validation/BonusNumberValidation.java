package lotto.validation;

import lotto.domain.LottoConstants;

import java.util.List;

public class BonusNumberValidation {

    public boolean isOne(List<Integer> bonusNumber) {
        if (bonusNumber.size() != LottoConstants.BONUS_NUMBER_COUNT) return false;

        return true;
    }

    public boolean isValidRange(List<Integer> bonusNumber) {
        if (bonusNumber.get(0) < LottoConstants.LOTTO_NUMBER_MIN || bonusNumber.get(0) > LottoConstants.LOTTO_NUMBER_MAX) return false;

        return true;
    }

    public boolean isDuplicated(List<Integer> lottoNumbers, List<Integer> bonusNumber) {
        for (Integer number : lottoNumbers) {
            if (number == bonusNumber.get(0)) return false;
        }

        return true;
    }
}