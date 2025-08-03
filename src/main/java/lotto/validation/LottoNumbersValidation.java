package lotto.validation;

import lotto.domain.LottoConstants;
import lotto.exception.LottoNumberCountException;
import lotto.exception.LottoNumberDuplicatedException;
import lotto.exception.LottoNumberRangeException;

import java.util.List;

public class LottoNumbersValidation {

    public boolean areSix(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LottoConstants.LOTTO_NUMBER_COUNT) {
            throw new LottoNumberCountException("[ERROR] 로또 번호는 6개를 입력해 주세요.");
        }

        return true;
    }

    public boolean areValidRange(List<Integer> lottoNumbers) {
        for (Integer number : lottoNumbers) {
            if (number < LottoConstants.LOTTO_NUMBER_MIN || number > LottoConstants.LOTTO_NUMBER_MAX) {
                throw new LottoNumberRangeException("[ERROR] 로또 번호는 1 ~ 45 사이의 숫자로 입력해 주세요.");
            }
        }

        return true;
    }

    public boolean areDuplicated(List<Integer> lottoNumbers) {
        for (int i = 0; i < LottoConstants.LOTTO_NUMBER_COUNT; i++) {
            for (int j = 0; j < LottoConstants.LOTTO_NUMBER_COUNT; j++) {
                if (i != j && lottoNumbers.get(i) == lottoNumbers.get(j)) {
                    throw new LottoNumberDuplicatedException("[ERROR] 로또 번호에 중복이 있으면 안 됩니다.");
                }
            }
        }

        return true;
    }
}