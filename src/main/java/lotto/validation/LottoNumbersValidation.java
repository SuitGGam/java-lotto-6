package lotto.validation;

import lotto.domain.LottoConstants;
import lotto.exception.LottoNumberCountException;
import lotto.exception.LottoNumberDuplicatedException;
import lotto.exception.LottoNumberRangeException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
        if (uniqueNumbers.size() != lottoNumbers.size()) {
            throw new LottoNumberDuplicatedException("[ERROR] 로또 번호에 중복이 있으면 안 됩니다.");
        }

        return true;
    }
}