package lotto.validation;

import lotto.domain.LottoConstants;

import java.util.List;

public class LottoNumbersValidation {

    public boolean areSix(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) return false;

        return true;
    }

    public boolean areValidRange(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) return false;
        }

        return true;
    }

    public boolean areDuplicated(List<Integer> lottoNumbers) {
        for (int i = 0; i < LottoConstants.LOTTO_NUMBER_COUNT; i++) {
            for (int j = 0; j < LottoConstants.LOTTO_NUMBER_COUNT; j++) {
                if (i != j && lottoNumbers.get(i) == lottoNumbers.get(j)) return false;
            }
        }

        return true;
    }
}